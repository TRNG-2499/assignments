package assignments.java.java_assignment_11.Exceptions;

public class InvalidDirectionException extends Exception {

    public enum Reason {
        INVALID,
        NO_EXIT,
        OCCUPIED
    }

    public InvalidDirectionException(String direction, Reason reason) {
        super(switch (reason) {
            case INVALID -> "Invalid direction: " + direction + " - Please use: north, south, east, west, up or down.";
            case NO_EXIT -> "There is no exit to the " + direction;
            case OCCUPIED -> "An exit already exists to the " + direction;
        });
    }
}