import java.util.Scanner;

public class Calculator {

    private int value = 0;
    private Integer lastValue;
    private CommandType lastCommandType;
    private String inputs = new String();
    private String[] lastTokens;
    private String buffer = new String();

    private static final String asBase = "%s %d. Running total: %d%n";
    private static final String curTotBase = "Current total: %d%n";
    private static final String rstBase = "Running total has been reset to 0.\n";
    private static final String exitBase = "Goodbye! Final total: %d";
    private static final String historyBase = "History:%n%s%n";
    private static final String undoBase = "Undid '%s'. Running total: %d%n";
    private static final String invNumBase = "'%s' requires a valid number. Please try again.%n";
    private static final String unkBase = "Unrecognized command: '%s'%n";

    private static enum CommandType {
        ADD,
        SUBTRACT,
        RESET,
        TOTAL,
        HISTORY,
        UNDO,
        EXIT,
        UNKNOWN,
        INVALID;

        public String toStringL() {
            return toString().toLowerCase();
        }
    }

    private void flush() {
        System.out.println(buffer);
        buffer = new String();
    }

    private void add(int x) {
        lastValue = value;
        value += x;
    }
    
    private void sub(int x) {
        lastValue = value;
        value -= x;
    }
    
    private void rst() {
        lastValue = value;
        value = 0;
    }
    
    private void undo() {
        value = lastValue;
    }

    private void nop() {}
    
    private CommandType tokToCommandType(String token) {
        CommandType type = CommandType.UNKNOWN;

        try {
            type = CommandType.valueOf(token.toUpperCase());
        } catch (Exception e) {}

        return type;
    }

    private String formatAddSubString(CommandType type, Integer operand) {
        String typeString = type.toStringL() + "ed";
        typeString = typeString.substring(0, 1).toUpperCase() + typeString.substring(1);
        return
            String.format(
                    asBase,
                    typeString,
                    operand,
                    value
                );
    }

    private String formatUndoString() {
        if (lastCommandType != null) {
            String lCTString = lastCommandType.toStringL();
            lastCommandType = null;
            return String.format(undoBase, lCTString, value);
        }

        return "Unable to undo previous command.\n";
    }

    private void writeBuffer(CommandType type, Integer operand) {
        buffer = switch(type) {
            case CommandType.ADD -> formatAddSubString(type, operand);
            case CommandType.SUBTRACT -> formatAddSubString(type, operand);
            case CommandType.RESET -> rstBase;
            case CommandType.TOTAL -> String.format(curTotBase, value);
            case CommandType.HISTORY -> String.format(historyBase, inputs);
            case CommandType.UNDO -> formatUndoString();
            case CommandType.EXIT -> String.format(exitBase, value);
            case CommandType.INVALID -> String.format(invNumBase, lastCommandType.toStringL());
            default -> String.format(unkBase, lastTokens.length > 0 ? lastTokens[0] : "");
        };
    }

    private void run(CommandType type, Integer operand) {
        switch (type) {
            case CommandType.ADD -> add(operand);
            case CommandType.SUBTRACT -> sub(operand);
            case CommandType.RESET -> rst();
            case CommandType.UNDO -> undo();
            default -> nop();
        };

        writeBuffer(type, operand);
        flush();
    }

    private String[] tokenize(String input) {
        return input.replace("\\W+", " ").trim().split(" ");
    }

    private boolean process(String input) {
        String[] tokens = tokenize(input);
        CommandType type = tokToCommandType(tokens[0]);
        Integer operand = null;

        if (tokens.length > 1) {
            try {
                operand = Integer.parseInt(tokens[1]);
            } catch (Exception e) {
                type = CommandType.INVALID;
            }
        }

        lastCommandType =
            switch(type) {
                case CommandType.ADD -> type;
                case CommandType.SUBTRACT -> type;
                case CommandType.RESET -> type;
                default -> lastCommandType;
            };

        if (type != CommandType.INVALID && type != CommandType.UNKNOWN) {
            inputs = inputs.concat(input + "\n");
        }
        lastTokens = tokens;

        run(type, operand);

        return switch(type) {
            case CommandType.EXIT -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();
            exit = calculator.process(input);
        }

        scanner.close();
    }
}
