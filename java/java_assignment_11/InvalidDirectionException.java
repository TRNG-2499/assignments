public class InvalidDirectionException extends RuntimeException {
    public InvalidDirectionException(String direction) {
        String customMsg = String.format("Error: There is no exit to the %s of here.%n", direction);
        super(customMsg);
    }
}
