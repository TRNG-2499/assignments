package com.letmegetabyte.wrapper;

import com.google.genai.Client;
import com.google.genai.gaos.models.interactions.Content;
import com.google.genai.gaos.models.interactions.CreateModelInteraction;
import com.google.genai.gaos.models.interactions.DocumentContent;
import com.google.genai.gaos.models.interactions.DocumentContentMimeType;
import com.google.genai.gaos.models.interactions.Interaction;
import com.google.genai.gaos.models.interactions.InteractionsInput;
import com.google.genai.gaos.models.interactions.Model;
import com.google.genai.gaos.models.interactions.TextContent;
import com.google.genai.gaos.models.operations.CreateInteractionRequestBody;
import com.google.genai.types.File;
import com.google.genai.types.UploadFileConfig;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Manages stateful, multi-turn conversations with Gemini.
 * <p>
 * Initialized with an initial prompt and optionally a CSV filepath.
 */
public class Conversation {
    private Client client = new Client();
    private final String model = "gemini-3.8-flash";
    private String prompt;
    private File csvFile;
    private Interaction prevInteraction;

    public Conversation(String initPrompt) {
        this.prompt = initPrompt;
        this.prevInteraction = interact(initPrompt);
    }

    public Conversation(String initPrompt, String csvFilepath) {
        this.prompt = initPrompt;
        this.prevInteraction = interact(initPrompt, csvFilepath);
    }

    private void loadCsv(String csvFilepath) {
        if (csvFilepath != null && !csvFilepath.isBlank()) {
            this.csvFile =
                client.files.upload(
                    csvFilepath,
                    UploadFileConfig.builder()
                        .mimeType("text/csv")
                        .displayName(csvFilepath)
                        .build());
        } else {
            this.csvFile = null;
        }
    }

    public Interaction interact() {
        InteractionsInput input;

        if (this.csvFile != null) {
            Content docContent =
                DocumentContent.builder()
                    .uri(this.csvFile.uri().orElse(""))
                    .mimeType(
                        this.csvFile
                            .mimeType()
                            .map(DocumentContentMimeType::of)
                            .orElse(DocumentContentMimeType.TEXT_CSV))
                    .build();
            Content textContent = TextContent.builder().text(this.prompt).build();

            List<Content> contents = Arrays.asList(docContent, textContent);
            input = InteractionsInput.ofContent(contents);
        } else {
            input = InteractionsInput.of(this.prompt);
        }

        CreateModelInteraction params =
            CreateModelInteraction.builder()
                .model(Model.of(this.model))
                .input(input)
                .previousInteractionId(this.prevInteraction != null ? this.prevInteraction.id().orElse("") : "")
                .build();

        Interaction interaction =
            client.interactions.create(CreateInteractionRequestBody.of(params)).interaction().get();
        this.prevInteraction = interaction;

        return interaction;
    }

    public Interaction interact(String prompt) {
        this.prompt = prompt;
        this.csvFile = null;
        return interact();
    }

    public Interaction interact(String prompt, String csvFilepath) {
        this.prompt = prompt;
        loadCsv(csvFilepath);
        return interact();
    }

    public String getResponse() {
        return this.prevInteraction != null ? this.prevInteraction.outputText().orElse("") : "";
    }

    public void archive(String filename, int ver) {
        String buffer;

        String input = this.prompt;
        String response = getResponse();

        if (this.csvFile != null) {
            String csvName = this.csvFile.displayName().orElse(this.csvFile.name().orElse(""));
            buffer = String.format("\n\n---!\nCSV:\n%s\n\nPrompt (ver %d):\n%s\n\nResponse:\n%s", csvName, ver, input, response);
        } else {
            buffer = String.format("\n\n---!\nPrompt (ver %d):\n%s\n\nResponse:\n%s", ver, input, response);
        }

        System.out.println(buffer);

        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(buffer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String filename, String log) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(String.format("\n\n---!\nLog:%s\n", log));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Conversation restart(String prompt) {
        return new Conversation(prompt);
    }

    public static Conversation restart(String prompt, String csvFilepath) {
        return new Conversation(prompt, csvFilepath);
    }
}
