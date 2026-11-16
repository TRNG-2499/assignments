public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String entity){
        super("There is no '" + entity + "' here to interact with.");
    }
}
