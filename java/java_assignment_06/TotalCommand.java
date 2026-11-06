public class TotalCommand extends Command {
  @Override
  public void apply(State s) {
    System.out.println("Total: " + s.getTotal());
  }
}
