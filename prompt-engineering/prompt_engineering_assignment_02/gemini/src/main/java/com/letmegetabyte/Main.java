package com.letmegetabyte;

import com.letmegetabyte.wrapper.Conversation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final Set<String> VALID_SENTIMENTS = Set.of("POSITIVE", "NEGATIVE", "NEUTRAL");

    private static boolean isHeaderRow(List<CSVRecord> records) {
        if (records.isEmpty() || records.get(0).size() == 0) {
            return false;
        }
        String firstCell = records.get(0).get(0).trim();
        if (firstCell.equalsIgnoreCase("id")
                || firstCell.equalsIgnoreCase("review_id")
                || firstCell.equalsIgnoreCase("review-id")
                || firstCell.equalsIgnoreCase("reviewid")
                || firstCell.equalsIgnoreCase("review id")) {
            return true;
        }
        if (records.size() > 1 && records.get(1).size() > 0) {
            String secondCell = records.get(1).get(0).trim();
            return !firstCell.matches(".*\\d.*") && secondCell.matches(".*\\d.*");
        }
        return false;
    }

    private static void validateRecord(
            CSVRecord record,
            long lineNum,
            Set<String> expectedIds,
            Set<String> seenIds,
            ArrayList<String> errors) {
        if (record.size() >= 1) {
            String candidateId = record.get(0).trim();
            if (!candidateId.isEmpty() && expectedIds.contains(candidateId) && record.size() != 3) {
                seenIds.add(candidateId);
            }
        }

        if (record.size() != 3) {
            errors.add(
                String.format(
                    "Line %d: invalid format — expected 3 CSV fields (review_id, sentiment, reason), got %d.",
                    lineNum,
                    record.size()));
            return;
        }

        String reviewId = record.get(0).trim();
        String sentiment = record.get(1).trim();
        String reason = record.get(2).trim();

        if (reviewId.isEmpty()) {
            errors.add(String.format("Line %d: missing review_id.", lineNum));
        } else if (!expectedIds.contains(reviewId)) {
            errors.add(
                String.format(
                    "Line %d: unexpected review_id '%s' (not in source CSV).", lineNum, reviewId));
        } else if (!seenIds.add(reviewId)) {
            errors.add(String.format("Line %d: duplicate review_id '%s'.", lineNum, reviewId));
        }

        String label = reviewId.isEmpty() ? "" : " (" + reviewId + ")";
        if (sentiment.isEmpty()) {
            errors.add(String.format("Line %d%s: missing sentiment.", lineNum, label));
        } else if (!VALID_SENTIMENTS.contains(sentiment)) {
            errors.add(
                String.format(
                    "Line %d%s: invalid sentiment '%s' (expected POSITIVE, NEGATIVE, or NEUTRAL).",
                    lineNum,
                    label,
                    sentiment));
        }

        if (reason.isEmpty()) {
            errors.add(String.format("Line %d%s: missing reason.", lineNum, label));
        }
    }

    public static ArrayList<String> verifyResults(String results, String csvFilepath) {
        ArrayList<String> errors = new ArrayList<>();

        if (csvFilepath == null || csvFilepath.isBlank()) {
            errors.add("CSV filepath is missing or blank.");
            return errors;
        }

        CSVFormat csvFormat =
            CSVFormat.DEFAULT.builder()
                .setTrim(true)
                .setIgnoreSurroundingSpaces(true)
                .setIgnoreEmptyLines(true)
                .get();

        List<CSVRecord> sourceRecords;
        try (CSVParser sourceParser =
                CSVParser.parse(Paths.get(csvFilepath), StandardCharsets.UTF_8, csvFormat)) {
            sourceRecords = sourceParser.getRecords();
        } catch (IOException | UncheckedIOException e) {
            errors.add("Failed to read source CSV '" + csvFilepath + "': " + e.getMessage());
            return errors;
        }

        int startIdx = isHeaderRow(sourceRecords) ? 1 : 0;
        Set<String> expectedIds = new LinkedHashSet<>();
        int expectedLineCount = 0;
        for (int i = startIdx; i < sourceRecords.size(); i++) {
            CSVRecord rec = sourceRecords.get(i);
            expectedLineCount++;
            if (rec.size() > 0 && !rec.get(0).trim().isEmpty()) {
                expectedIds.add(rec.get(0).trim());
            }
        }

        if (results == null || results.isBlank()) {
            errors.add(
                String.format("Results output is empty (expected %d lines).", expectedLineCount));
            for (String id : expectedIds) {
                errors.add("Missing review_id: " + id);
            }
            return errors;
        }

        Set<String> seenIds = new HashSet<>();
        List<String> nonEmptyLines =
            results.lines().map(String::trim).filter(line -> !line.isEmpty()).toList();

        try (CSVParser resultParser = CSVParser.parse(results.trim(), csvFormat)) {
            List<CSVRecord> resultRecords = resultParser.getRecords();

            if (resultRecords.size() != expectedLineCount
                    || nonEmptyLines.size() != expectedLineCount) {
                errors.add(
                    String.format(
                        "Line count mismatch: expected %d lines, got %d lines (%d CSV records).",
                        expectedLineCount,
                        nonEmptyLines.size(),
                        resultRecords.size()));
            }

            for (CSVRecord record : resultRecords) {
                validateRecord(record, record.getRecordNumber(), expectedIds, seenIds, errors);
            }
        } catch (IOException | UncheckedIOException e) {
            errors.add("Malformed CSV syntax in results: " + e.getMessage());
            if (nonEmptyLines.size() != expectedLineCount) {
                errors.add(
                    String.format(
                        "Line count mismatch: expected %d lines, got %d.",
                        expectedLineCount,
                        nonEmptyLines.size()));
            }
            for (int i = 0; i < nonEmptyLines.size(); i++) {
                String line = nonEmptyLines.get(i);
                try (CSVParser lineParser = CSVParser.parse(line, csvFormat)) {
                    List<CSVRecord> lineRecords = lineParser.getRecords();
                    if (!lineRecords.isEmpty()) {
                        validateRecord(lineRecords.get(0), i + 1L, expectedIds, seenIds, errors);
                    }
                } catch (IOException | UncheckedIOException lineErr) {
                    errors.add(
                        String.format(
                            "Line %d: malformed CSV row (%s).", i + 1, lineErr.getMessage()));
                }
            }
        }

        for (String expectedId : expectedIds) {
            if (!seenIds.contains(expectedId)) {
                errors.add("Missing review_id: " + expectedId);
            }
        }

        return errors;
    }

    public static void main(String[] args) {
        String csvPath = "product-reviews.csv";
        String basePrompt = "Are these reviews positive or negative?";
        String role = "You are a sentiment analysis agent. Designed to grade the sentiment of reviews.";
        String context1 = "The reviews are for various products sold online.";
        String context2 = "Sentiment analysis will be programmatically parsed for completeness and analysis.";
        String constraint = "The reasoning should be unopinionated, concise, and limited to a few descriptive words.";
        String example = "Example response:\nR001,NEGATIVE,\"smell\"\nR004,NEGATIVE,\"comfort\"";
        String format = "Reply in one line, ordered review-id sentiment reason.";

        // build context
        String ctx = String.format("%s %s", context1, context2);
        // build base + role + format
        String promptBRF = String.format("%s\n%s\n%s", role, basePrompt, format);
        // build base + role + format + ctx
        String promptBRFC = String.format("%s\n%s\n%s\n%s", role, basePrompt, ctx, format);
        // build base + role + format + ctx + example + constraint
        String promptBRFCEC = String.format("%s\n%s\n%s\n%s\n%s\n%s", role, basePrompt, ctx, format, constraint, example);

        String[] prompts = {basePrompt, promptBRF, promptBRFC, promptBRFCEC};

        for (int i = 0; i < prompts.length; i++) {
            String prompt = prompts[i];
            Conversation conversation = new Conversation(prompt, csvPath);
            conversation.archive(String.format("logs-%d.txt", i), i);
            ArrayList<String> errors = verifyResults(conversation.getResponse(), csvPath);
            conversation.log(String.format("logs-%d.txt", i), errors.toString());
        }
    }
}