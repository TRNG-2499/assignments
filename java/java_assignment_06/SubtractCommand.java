public class SubtractCommand extends Command {
  @Override
  public void apply(State s) {
    s.setTotal(s.getTotal() - s.getNextInt());
  }
}
