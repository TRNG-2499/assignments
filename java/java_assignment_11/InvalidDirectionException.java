/**
 * Thrown when a move command names a direction with no exit from the current
 * room.
 */
public class InvalidDirectionException extends Exception {

    public InvalidDirectionException(String direction) {
        super("Error: There is no exit to the '" + direction + "' of here.");
    }
}
