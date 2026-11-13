public class NoSuchEntityException extends Exception {
  public NoSuchEntityException(String name) {
    super("There is no '" + name + "'.");
  }
}
