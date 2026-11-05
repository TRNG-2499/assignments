import java.util.Scanner;

public class TrafficLightSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Starting Light Color: ");
        String startingColor = scanner.nextLine();
        System.out.println("Enter number of ticks: ");
        int ticks = scanner.nextInt();

        String result = lights(startingColor, ticks);
        System.out.println("Traffic Light After " + ticks + " ticks  is : " + result);

        scanner.close();
    }
    
    public static String lights(String startingColor, int ticks){

        //validate negative tick count

        if(ticks < 0){
            return "Invalid input: ticks can not be negative.";
        }

        //validating staring color
        if(startingColor == null || ! (startingColor.equalsIgnoreCase("Yellow") || startingColor.equalsIgnoreCase("Red" )|| startingColor.equalsIgnoreCase("Green"))){
            return "Invalid Input: " + startingColor + " can not be recognized as a light color. ";
        }

        String currentColor = startingColor;

        int remainingTicks = ticks % 3; //Only process remaining ticks after full cycles

        for (int i =0; i<remainingTicks; i++){
            switch(currentColor){
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
        }
        return currentColor;
    }
}