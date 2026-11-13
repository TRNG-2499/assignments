public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(){
        super("Error: Invalid entity");
    }

    public EntityNotFoundException(String entity){
        super("Error: Entity "+entity+" was not found!");
    }
}
