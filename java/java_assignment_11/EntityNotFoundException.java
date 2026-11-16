public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String entity) {
        super(String.format("'%s' not found in current room.", entity));
    }
}
