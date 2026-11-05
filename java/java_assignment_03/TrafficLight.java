package assignments.java.java_assignment_03;

public class TrafficLight {
     public static void main(String[] args) {
        trafficLight("Green", 1);
        trafficLight("Green", 3);
        trafficLight("Red", 5);
        trafficLight("Green", 0);
        trafficLight("Purple", 2);
        trafficLight("Green", -3);
    }

    public static void trafficLight(String color, int tsteps) {
        if (tsteps < 0) {
            System.out.println("Invalid input: tick count cannot be negative.");
        }
        tsteps %= 3;
        switch (color) {
            case "Green":
                switch (tsteps) {
                    case 2:
                        System.out.println("Red");
                        break;
                    case 1:
                        System.out.println("Yellow");
                        break;
                    default:
                        System.out.println("Green");
                        break;
                }
                break;
            case "Yellow":
                switch (tsteps) {
                    case 2:
                        System.out.println("Green");
                        break;
                    case 1:
                        System.out.println("Red");
                        break;
                    default:
                        System.out.println("Yellow");
                        break;
                }
                break;
            case "Red":
                switch (tsteps) {
                    case 2:
                        System.out.println("Yellow");
                        break;
                    case 1:
                        System.out.println("Green");
                        break;
                    default:
                        System.out.println("Red");
                        break;
                }
                break;
            default:
                System.out.println("Invalid input: '"+ color +"' is not a recognized light color.");
                break;
        }
    }
}
