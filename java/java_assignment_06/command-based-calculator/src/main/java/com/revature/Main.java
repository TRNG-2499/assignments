package com.revature;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        List<String> history = new ArrayList<>();
        // totals from before each add/subtract/reset, newest on top, so each undo steps back one change
        Deque<Integer> undoStack = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);

        String command = "";
        while (!command.equals("exit")) {
            System.out.print("Enter a command (add [number], subtract [number], reset, total, history, undo, exit): ");
            String[] parts = scanner.nextLine().trim().split("\\s+");
            command = parts[0];

            // stays null if the number is missing or isn't a whole number, so add/subtract can report it
            Integer num = null;
            if (parts.length > 1) {
                try {
                    num = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    // leave num as null
                }
            }

            boolean valid = isValidCommand(command, num);

            if (command.equals("history")) {
                // stretch goal 1
                printHistory(history);
            } else if (command.equals("undo")) {
                // stretch goal 2
                total = undo(undoStack, total);
            } else {
                if (valid && (command.equals("add") || command.equals("subtract") || command.equals("reset"))) {
                    undoStack.push(total);
                }
                total = calculatorCommands(command, num, total);
            }

            if (valid) {
                history.add(command.equals("add") || command.equals("subtract") ? command + " " + num : command);
            }
        }

        scanner.close();
    }

    public static int calculatorCommands(String command, Integer num, int total){
        switch (command) {
            case "add":
                if (num == null) {
                    System.out.println("'add' requires a valid number, try again.");
                    break;
                }
                total += num;
                System.out.println("Added " + num + ", New total is: " + total);
                break;
            
            case "subtract":
                if (num == null) {
                    System.out.println("'subtract' requires a valid number, try again.");
                    break;
                }
                total -= num;
                System.out.println("Subtracted " + num + ", New total is: " + total);
                break;
                
            case "reset":
                total = 0;
                System.out.println("Total has been reset to 0");
                break;

            case "total":
                System.out.println("Current total: " + total);
                break;

            case "exit":
                System.out.println("Goodbye! Final total: " + total);
                break;

            default:
                System.out.println("Unrecognized command: " + command + ", try again");
                break;
        }
        return total;
    }

    public static boolean isValidCommand(String command, Integer num) {
        switch (command) {
            case "add":
            case "subtract":
                return num != null;
            case "reset":
            case "total":
            case "history":
            case "undo":
            case "exit":
                return true;
            default:
                return false;
        }
    }

    // stretch goal 1
    public static void printHistory(List<String> history) {
        if (history.isEmpty()) {
            System.out.println("No commands entered yet");
            return;
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    // stretch goal 2
    public static int undo(Deque<Integer> undoStack, int total) {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return total;
        }
        int previous = undoStack.pop();
        System.out.println("Undid last command, New total: " + previous);
        return previous;
    }
}