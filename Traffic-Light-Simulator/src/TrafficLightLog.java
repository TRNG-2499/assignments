import java.util.Arrays;
import java.util.Scanner;

public class TrafficLightLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the starting color: ");
        String startingColor = scanner.nextLine();
        System.out.println("Please Enter the ticks: ");
        int ticks = scanner.nextInt();

        String [] result = getTrafficLightLog(startingColor, ticks);
        System.out.println("Here is the traffic light history: " + Arrays.toString(result));

        scanner.close();
    }

    public static String[] getTrafficLightLog(String startingColor, int ticks) {
        //Check for negative ticks first

        if (ticks < 0) {
            return new String[]{"Invalid Input, because ticks can not be negative. "};
        }

        if (startingColor == null || !(startingColor.equalsIgnoreCase("yellow") || startingColor.equalsIgnoreCase("red") || startingColor.equalsIgnoreCase("green"))) {
            return new String[]{"Invalid Input: Unrecognized light color. "};
        }

        String[] colorLog = new String[ticks];
        String currentColor = startingColor;

        for (int i = 0; i < ticks; i++) {

            //Java's switch statement is case-sensitive,
            switch (currentColor.toLowerCase()) {
                case "green":
                    currentColor = "Yellow";
                    break;

                case "yellow":
                    currentColor = "Red";
                    break;

                case "red":
                    currentColor = "Green";
                    break;
            }
            colorLog[i] = currentColor;
        }
        return colorLog;

    }
}
