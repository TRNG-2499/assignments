public class InvalidDirectionException extends Exception{
    public InvalidDirectionException(){
        super("Invalid direction provided.");
    }

    public InvalidDirectionException(String direction){
        super("Error: no room to the "+direction);
    }
}
