package java_assignment_11;

public class InvalidDirectionException extends RuntimeException {
    public InvalidDirectionException(String direction, String roomName) {
        super("There is no exit to the " + direction + " from the " + roomName + ".");
    }
}
