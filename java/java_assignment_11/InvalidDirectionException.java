public class InvalidDirectionException extends GameException {
    public InvalidDirectionException(String direction) {
        super("There is no exit to the " + direction + " from here.");
    }
}
