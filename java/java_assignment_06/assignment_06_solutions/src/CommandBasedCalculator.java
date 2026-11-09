import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandBasedCalculator {

    public static void main() {
        CommandBasedCalculator instance = new CommandBasedCalculator();
        instance.stretchLoop();
    }

    private int runningValue = 0;
    private boolean endProgram = false;

    String userPrompt =
            "Enter one of these commands:" +
            "\n 'add (number)', 'subtract (number)', reset, total, exit";
    String userPromptStretch =
            "Enter one of these commands:" +
                    "\n 'add (number)', 'subtract (number)', reset, total, history, undo, exit";
    List<String> userOptions = new ArrayList<>(List.of("add", "subtract", "reset", "total", "exit"));

    public void loop() {
        System.out.println("Calculator App");
        boolean endProgram = false;
        Scanner scanner = new Scanner(System.in);

        while(!getEndProgram()) {
            System.out.println("------------");
            System.out.println(userPrompt);

            String[] inputTokens = getInput(scanner);
            if (!validInput(inputTokens)) {
                System.out.println("Error: Invalid input.\n");
                continue;
            }
            processUserInput(scanner, inputTokens);
        }
        scanner.close();
    }

    public void processUserInput(Scanner scanner, String[] inputTokens) {
        switch(inputTokens[0]) {
            case "exit" -> {
                setEndProgram(true);
            }
            case "add" -> {
                try {
                    String num = inputTokens[1];
                    add(num);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            case "subtract" -> {
                try {
                    String num = inputTokens[1];
                    subtract(num);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            case "reset" -> {
                reset();
            }
            case "total" -> {
                printTotal();
            }
        }
    }

    public int getRunningValue() {
        return runningValue;
    }

    private void setRunningValue(int runningValue) {
        this.runningValue = runningValue;
    }

    public boolean getEndProgram() {
        return endProgram;
    }

    private void setEndProgram(boolean b) {
        endProgram = b;
    }

    public String[] getInput(Scanner scanner) {
        String input = scanner.nextLine();
        return input.split("\\s+");
    }

    public boolean validInput(String[] inputTokens) {
        return inputTokens.length != 0
                && !inputTokens[0].isEmpty()
                && userOptions.stream().anyMatch(inputTokens[0]::equals);
    }

    public void add(String s) {
        if (intIsValid(s)) {
            setRunningValue(getRunningValue() + Integer.parseInt(s));
            System.out.println("Added " + s + ". Running total: " + getRunningValue());
        } else {
            throw new IllegalArgumentException("Invalid input. Please enter a valid integer to add.");
        }
    }

    public void subtract(String s) {
        if (intIsValid(s)) {
            setRunningValue(getRunningValue() - Integer.parseInt(s));
            System.out.println("Subtracted " + s + ". Running total: " + getRunningValue());
        } else {
            throw new IllegalArgumentException("Invalid input. Please enter a valid integer to subtract.");
        }
    }

    public void reset() {
        setRunningValue(0);
        System.out.println("Running total has been reset to zero.");
    }

    public void printTotal() {
        System.out.println("Current running total: " + getRunningValue());
    }

    public boolean intIsValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<String[]> history = new ArrayList<String[]>();

    public void stretchLoop() {
        System.out.println("Calculator App");
        Scanner scanner = new Scanner(System.in);
        userOptions.add("history");
        userOptions.add("undo");

        while(!getEndProgram()) {
            System.out.println("------------");
            System.out.println(userPromptStretch);

            String[] inputTokens = getInput(scanner);
            if (!validInput(inputTokens)) {
                System.out.println("Error: Invalid input.\n");
                continue;
            }
            processUserInputStretch(inputTokens);
            history.add(inputTokens);
        }
        scanner.close();
    }

    public void processUserInputStretch(String[] inputTokens) {
        switch(inputTokens[0]) {
            case "exit" -> {
                setEndProgram(true);
            }
            case "add" -> {
                try {
                    String num = inputTokens[1];
                    add(num);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            case "subtract" -> {
                try {
                    String num = inputTokens[1];
                    subtract(num);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            case "reset" -> {
                reset();
            }
            case "total" -> {
                printTotal();
            }
            case "history" -> {
                System.out.println("Command history:\n" + Arrays.deepToString(history.toArray()));
            }
            case "undo" -> {
                String[] operators = {"add", "subtract", "reset"};
                for (int i = history.size() - 1; i >=0; i--) {
                    String[] command = history.get(i);
                    String operator = command[0];
                    switch(operator) {
                        case "add", "subtract" -> {
                            int temp = Integer.parseInt(command[1]);
                            command[1] = Integer.toString(-temp);
                            processUserInputStretch(command);
                            return;
                        }
                        case "reset" -> {
                            processUserInputStretch(command);
                            return;
                        }
                    }
                }
                System.out.println("There are no previous actions to undo.");
            }
        }
    }
}