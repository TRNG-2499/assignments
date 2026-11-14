public class EntityNotFoundException extends GameException {
    public EntityNotFoundException(String name) {
        super("There is no '" + name + "' here to interact with.");
    }
}
