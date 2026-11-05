public class trafficLightGP {

    public static void main(String[] args) {
        System.out.println(trafficLight("Green", 0));
        System.out.println(trafficLight("Green", 1));
        System.out.println(trafficLight("Yellow", 2));
        System.out.println(trafficLight("Red", 4));
        System.out.println(trafficLight("Green", 100));

    }

    public static String trafficLight(String startColor, int ticks) {
        if (startColor == null) {
            return "Starting color is not a valid traffic light color";
        }

        if (ticks < 0) {
            return "Number of ticks must be positive";
        }

        int startIndex = 0;
        switch(startColor) {
            case "Green":
                startIndex = 0;
                break;
            case "Yellow":
                startIndex = 1;
                break;
            case "Red":
                startIndex = 2;
                break;
            default:
                return "This is not a valid traffic light color";
        }

        int endIndex = (startIndex + ticks) % 3;

        switch (endIndex) {
            case 0:
                return "Green";
            case 1:
                return "Yellow";
            case 2:
                return "Red";
        }

        return "This string is unreachable";
    }

}
