package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "log", mixinStandardHelpOptions = true, description = "Log completed coding challenges.")
public class Log implements Runnable {
    private static final Path filename = Path.of("logs.csv");
    private static final String HEADER = "challenge_name,difficulty,date_completed,language,platform" + System.lineSeparator();

    @Option(names = "-n", required = true, description = "specify name")
    String name;

    @Option(names = "-d", required = true, description = "specify difficulty")
    String diff;

    @Option(names = "-D", description = "specify date (YYYY-MM-DD)")
    String date = LocalDate.now().toString();

    @Option(names = "-L", description = "specify language")
    String lang = "Java";

    @Option(names = "-p", required = true, description = "specify platform")
    String platform;

    @Override
    public void run() {
        try {
            if (!Files.exists(filename)) {
                Files.writeString(filename, HEADER, StandardOpenOption.CREATE);
            }
            String entry = String.format("%s,%s,%s,%s,%s%n", name, diff, date, lang, platform);
            Files.writeString(filename, entry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Log()).execute(args);
        System.exit(exitCode);
    }
}