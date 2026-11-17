/**
 * Thrown when an interact command names an entity that isn't in the current
 * room.
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String entityName) {

        super("Error: There is no '" + entityName + "' to interact with here");
    }
}
