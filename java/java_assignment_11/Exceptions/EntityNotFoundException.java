package assignments.java.java_assignment_11.Exceptions;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entityName) {
        super(entityName + ": Does not exist");
    }
}
