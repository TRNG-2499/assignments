package java_assignment_11;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, String roomName) {
        super("There is no '" + entityName + "' in the " + roomName + " to interact with.");
    }
}
