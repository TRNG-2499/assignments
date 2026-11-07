import java.util.Scanner;

public class TrafficLight {
    public static void currentLight(String color, int tick)
    {
        int state = tick % 3;
        String[] colors = {"red", "green", "yellow"};
        String currentColor = "";

        switch(color.toLowerCase())
        {
            case "red":
                currentColor = colors[(state + 0) % 3];
                break;
            case "green":
                currentColor = colors[(state + 1) % 3];
                break;

            case "yellow":
                currentColor = colors[(state + 2) % 3];
                break;

            default:
                System.out.println("Invalid color input. Please enter 'red', 'green', or 'yellow'.");
                return;
        }

        System.out.println("Current light color: " + currentColor);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current light color (red, green, yellow): ");
        String color = scanner.nextLine();

        System.out.print("Enter the tick value (integer): ");
        int tick = scanner.nextInt();

        currentLight(color, tick);
    }
}
