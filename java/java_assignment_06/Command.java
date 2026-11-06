import java.util.HashMap;
import java.util.function.Supplier;

public abstract class Command {
  public abstract void apply(State s);

  public static Command get(String name) {
    name = name.toLowerCase();
    Supplier<Command> command_supplier = commands.get(name);
    if (command_supplier == null) {
      throw new IllegalArgumentException("Unknown command '" + name + "'");
    }
    return command_supplier.get();
  }

  private static HashMap<String, Supplier<Command>> commands = new HashMap<>();

  static {
    commands.put("add", AddCommand::new);
    commands.put("subtract", SubtractCommand::new);
    commands.put("reset", ResetCommand::new);
    commands.put("total", TotalCommand::new);
    commands.put("exit", ExitCommand::new);
  }
}
