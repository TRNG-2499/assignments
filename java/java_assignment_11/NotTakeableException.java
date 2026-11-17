public class NotTakeableException extends Exception {
    public NotTakeableException(String name) {
        super("The " + name + " is too big to take.");
    }
}