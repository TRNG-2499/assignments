public class AddCommand extends Command {
  @Override
  public void apply(State s) {
    s.setTotal(s.getTotal() + s.getNextInt());
  }
}
