import java.util.Arrays;

public class Solution_03 {

  public static void main(String[] args) {
    System.out.println(lightSim("Green", 0)); // g
    System.out.println(lightSim("Green", 1)); // y
    System.out.println(lightSim("Yellow", 2)); // g
    System.out.println(lightSim("Red", 5)); // y
    System.out.println(lightSim("Blue", 2)); // invalid
    System.out.println(lightSim("Green", -1)); // invalid

    //strech test
    System.out.println(Arrays.toString(lightSimFullCycleLog("Green", 4)));
    System.out.println(Arrays.toString(lightSimFullCycleLog("Yellow", 3)));
    System.out.println(Arrays.toString(lightSimFullCycleLog("Red", 0)));
    System.out.println(Arrays.toString(lightSimFullCycleLog("Blue", 2)));

    // todo
    // input norm GREEN Green and green are all Green;
    // other two strech goals
  }

  public static String lightSim(String color, int ticks) {
    String validCheck = validInput(color, ticks);
    if (!validCheck.isEmpty()) return validCheck;

    if (ticks == 0) return color;

    int startingTick = color.equalsIgnoreCase("green")
      ? 0
      : color.equalsIgnoreCase("yellow")
        ? 1
        : 2;
    int totalTicks = (ticks + startingTick) % 3;

    switch (totalTicks) {
      case 0:
        return "Green";
      case 1:
        return "Yellow";
      default:
        return "Red";
    }
  }

  private static String validInput(String color, int ticks) {
    if (ticks < 0) return "Invalid, ticks must be positive number";
    if (color == null) return "Invalid Color cannot be empty";
    if (
      !color.equalsIgnoreCase("green") &&
      !color.equalsIgnoreCase("yellow") &&
      !color.equalsIgnoreCase("red")
    ) {
      return "Invalid, Color must be Green, Yellow or Red";
    }
    return "";
  }

  public static String[] lightSimFullCycleLog(String color, int ticks) {
    String validCheck = validInput(color, ticks);
    if (!validCheck.isEmpty()) return new String[] { validCheck };

    String[] result = new String[ticks];
    String colorIndex = color;
    for (int i = 0; i < ticks; i++) {
      switch (colorIndex) {
        case "Green":
          colorIndex = "Yellow";
          result[i] = colorIndex;
          break;
        case "Yellow":
          colorIndex = "Red";
          result[i] = colorIndex;
          break;
        case "Red":
          colorIndex = "Green";
          result[i] = colorIndex;
          break;
      }
    }
    return result;
  }
}
