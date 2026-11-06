public class ResetCommand extends Command {
  @Override
  public void apply(State s) {
    s.setTotal(0);
  }
}
