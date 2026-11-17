/** Thrown when an interact command names an entity that isn't in the current room. */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String entityName) {
        // TODO: pass a clear message to super, e.g. "There is no 'Toaster' here to interact with."
        super();
    }
}
