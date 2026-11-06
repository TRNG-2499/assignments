public class ExitCommand extends Command {
  @Override
  public void apply(State s) {
    throw new ExitException();
  }
}
