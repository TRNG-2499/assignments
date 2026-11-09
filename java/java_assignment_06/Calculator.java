import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Calculator {
    private static final Deque<int[]> historyStack = new ArrayDeque<>();
    private static final String[] COMMAND_STRINGS = {"reset","add","subtract","total","history","undo"};
    private static int total = 0;
    private static int running = 1;
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a command: ");
            String commandInput = scanner.nextLine();
            int[] command = parseInput(commandInput);

            switch (command[0]) {
                case 0 -> reset();
                case 1 -> addSubtract(command[1], 0);
                case 2 -> addSubtract(command[1], 1);
                case 3 -> total();
                case 4 -> history(false);
                case 5 -> undo();
                case -1 -> running = -1;
                case -2 -> System.out.printf("Unrecognised command '%s'.\n", commandInput.split(" ",2)[0]);
                case -3 -> System.out.printf("%s requires a valid number. Please try again.\n", COMMAND_STRINGS[command[1]]);
                case -4 -> System.out.println("Non-empty input required");
                default -> System.out.println("?");
            }
            
        } while (running > 0);
        System.out.printf("Goodbye! Final total: %d\n", total);
    }

    public static int[] parseInput(String inString) {
        int[] command = {-2, 0};
        if (inString == null || inString.isBlank()) {
            command[0] = -4;
            return command;
        }

        if (inString.strip().equalsIgnoreCase("exit")) {
            command[0] = -1;
            return command;
        }

        String[] tmp = inString.split(" ");
        
        for (int i = 0; i < COMMAND_STRINGS.length; i++) {
            if (COMMAND_STRINGS[i].equalsIgnoreCase(tmp[0])) {
                command[0] = i;
            }
        }

        if (command[0] == 1 || command[0] == 2) {
            try {
                command[1] = Integer.parseInt(tmp[1]);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                command[1] = command[0];
                command[0] = -3; 
                return command;
            }
        }
        

        return command;
    }

    public static void addSubtract(int a, int m) {
        int[] entry = {m+1, a, total};
        historyStack.push(entry);
        total = total + (m==0?a:-a);
        System.out.printf("%s %d. Running total: %d\n",(m==0?"Added":"Subtracted"), a, total);
    }

    public static void reset() {
        int[] entry = {0, 0, total};
        historyStack.push(entry);
        total = 0;
        System.out.println("Running total has been reset to 0.\n");
    }

    public static void total() {
        int[] entry = {3, 0, total};
        historyStack.push(entry);
        System.out.printf("Current total: %d\n", total);
    }

    public static void history(boolean reversed) {
        Iterator<int[]> iter = reversed ? historyStack.descendingIterator() : historyStack.iterator();
        
        while(iter.hasNext()) {
            int[] entry = iter.next();
            System.out.println(entryToString(entry)); 
        }

        int[] newEntry = {4, 0, total};
        historyStack.push(newEntry);
    }

    public static String entryToString(int[] entry) {
        String s;
        if (entry[0] == 1 || entry[0] == 2) {
            s = String.format("%s %d", COMMAND_STRINGS[entry[0]], entry[1]);
            return s;
        } else if (entry[0] == 5) {
            s = String.format("undo %s", COMMAND_STRINGS[entry[1]]);
            return s;
        }
        return COMMAND_STRINGS[entry[0]];
    }

    public static void undo() {
        Iterator<int[]> iter = historyStack.iterator();
        int undoCounter = 0;
        while(iter.hasNext()){
            int[] entry = iter.next();
            if (entry[0] == 5) undoCounter++;
            else if (entry[0] < 3) {
                undoCounter--;
                if (undoCounter < 0) {
                    System.out.printf("Undid the last command '%s'. Running Total: %d\n", entryToString(entry), entry[2]);
                    int[] newEntry = {5, entry[0], total};
                    total = entry[2];
                    historyStack.push(newEntry);
                    return;
                }
            }
        }

        System.out.printf("No valid previous commands to Undo\n");

    }
}