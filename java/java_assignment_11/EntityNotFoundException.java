public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String name, String action) {
        super("There is no '" + name + "' here to " + action + ".");
    }
}