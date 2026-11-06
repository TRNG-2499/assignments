public class Main {
  public static void main(String[] args) {
    State s = new State();
    try {
      while (true) {
        try {
          System.out.print("> ");
          Command.get(s.getNextString()).apply(s);
        } catch (IllegalArgumentException e) {
          System.out.println("Invalid command");
        } catch (Exception e) {
          throw e;
        }
      }
    } catch (ExitException e) {
    } finally {
      s.close();
    }
  }
}
