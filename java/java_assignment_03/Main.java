public class Main {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Invalid arguments. Usage: <color> <ticks>");
      return;
    }

    try {
      LightColor color = LightColor.valueOf(args[0]);
      int ticks = Integer.parseInt(args[1]);

      if (ticks < 0) {
        throw new RuntimeException("Ticks cannot be negative.");
      }

      System.out.printf("Started at '%s'%n", color);

      LightColor simulated_color = simulate(color, ticks);
      System.out.printf("Base: Ended at '%s' after %d ticks%n", simulated_color, ticks);

      LightColor simulated_variable_duration = simulateVariableDuration(color, ticks);
      System.out.printf("Variable duration: Ended at '%s' after %d ticks%n", simulated_variable_duration, ticks);
    } catch (NumberFormatException e) {
      System.out.println("Ticks is not a number.");
    } catch (IllegalArgumentException e) {
      System.out.printf("Unknown color '%s'%n", args[0]);
    } catch (RuntimeException e) {
      System.out.printf("Error: %s%n", e.getMessage());
    }
  }

  private static LightColor simulate(LightColor color, int ticks) {
    for (int i = 0; i < ticks; i++) {
      color = color.next();
    }

    return color;
  }

  private static LightColor simulateVariableDuration(LightColor color, int ticks) {
    int elapsed = 0;
    for (int i = 0; i < ticks; i++) {
      LightColor next = color.next(++elapsed);
      if (color != next) {
        color = next;
        elapsed = 0;
      }
    }

    return color;
  }
}
