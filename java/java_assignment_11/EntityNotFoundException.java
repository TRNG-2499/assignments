public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName) {
        String customMsg = String.format("Error: There is no '%s' here to interact with", entityName);
        super(customMsg);
    }
}
