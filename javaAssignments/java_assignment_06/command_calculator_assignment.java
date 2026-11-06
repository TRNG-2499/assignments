package javaAssignments.java_assignment_06;

import java.util.Scanner;

public class command_calculator_assignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0; // Initialize the running total
        int number; //this value is used for operations
        java.util.List<String> history = new java.util.ArrayList<>(); // Store the history of operations, added as part of stretch goal
        showDisplay();
        while (true) {
            String choice = sc.nextLine().toLowerCase();
            switch (choice) { //math logic below
                case "1" -> {
                    System.out.println("Enter a number to add: ");
                    number = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt()
                    total += number;
                    history.add("Added " + number + " to total"); // Record the addition in history as a stromg
                }
                case "2" -> {
                    System.out.println("Enter a number to subtract: ");
                    number = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left by nextInt()
                    total -= number;
                    history.add("Subtracted " + number + " from total");
                }
                case "3" -> {
                    int temp = total; // Store the current total before resetting
                    total = 0;
                    System.out.println("Reset Successful");
                    history.add("Total reset to 0 from " + temp);
                }
                case "4" -> System.out.println("Running Total: " + total);
                case "5" -> {
                    sc.close();
                    return;
                }
                case "6" -> {
                    System.out.println("History of operations:");
                    for (String entry : history) {
                        System.out.println(entry);
                    }
                }
                case "7" -> {
                    if (!history.isEmpty()) {
                        String lastOperation = history.get(history.size() - 1);
                        history.remove(history.size() - 1);
                        if (lastOperation.startsWith("Added ")) {
                            number = Integer.parseInt(lastOperation.split(" ")[1]);
                            total -= number;
                        } else if (lastOperation.startsWith("Subtracted ")) {
                            number = Integer.parseInt(lastOperation.split(" ")[1]);
                            total += number;
                        } else if (lastOperation.startsWith("Total reset to 0 from ")) {
                            total = Integer.parseInt(lastOperation.split(" ")[5]);
                        }
                        System.out.println("Undid last operation: " + lastOperation);
                    } else {
                        System.out.println("No operations to undo");
                    }
                }
                default -> System.out.println("Invalid choice"); // Handle invalid menu choice
            }
            showDisplay();
        }
    }

    public static void showDisplay() {
        System.out.println("Choose from available commands");
        System.out.println("[1] Add");
        System.out.println("[2] Subtract");
        System.out.println("[3] Reset");
        System.out.println("[4] Total");
        System.out.println("[5] Exit");
        System.out.println("[6] History"); //This was added as part of a stretch goal
        System.out.println("[7] Undo"); //added as part of a stretch goal
    }
}
