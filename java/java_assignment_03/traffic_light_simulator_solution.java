import java.util.*;


public static void main(String[] args){
    //Scanner is just for testing purposes
    Scanner scanner = new Scanner(System.in);

    System.out.println("List the color of the light between Green, Yellow, or Red");
    String color = scanner.nextLine();

    System.out.println("List the number of ticks that go by");
    int tick = scanner.nextInt();

    TrafficLight(color, tick);

    scanner.close();
}

public static void TrafficLight(String color, int tick){
    System.out.println("Start color: " + color + " and tick: " + tick);
    switch (color.toLowerCase()) {
        case "green":
            switch (tick % 3) {
                case 0:
                    System.out.println("Final color: Green");
                    break;
                case 1:
                    System.out.println("Final color: Yellow");
                    break;
                case 2:
                    System.out.println("Final color: Red");
                    break;
            }
            break;

        case "yellow":
            switch (tick % 3) {
                case 0:
                    System.out.println("Final color: Yellow");
                    break;
                case 1:
                    System.out.println("Final color: Red");
                    break;
                case 2:
                    System.out.println("Final color: Green");
                    break;
            }
            break;

        case "red":
            switch (tick % 3) {
                case 0:
                    System.out.println("Final color: Red");
                    break;
                case 1:
                    System.out.println("Final color: Green");
                    break;
                case 2:
                    System.out.println("Final color: Yellow");
                    break;
            }
            break;

        default:
            System.out.println("Invalid color. Please select a valid color.");
    }
}