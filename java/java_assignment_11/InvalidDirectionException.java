/** Thrown when a move command names a direction with no exit from the current room. */
public class InvalidDirectionException extends Exception {

    public InvalidDirectionException(String direction) {
        // TODO: pass a clear message to super, e.g. "There is no exit to the west from here."
        super();
    }
}
