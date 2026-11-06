class Main {

    String traffic_sim(String color, int steps) {
        String newColor = new String();
            for(int i = 0; i < steps; i++) {
                newColor = switch(color) {
                    case "Green" -> "Yellow";
                    case "Yellow" -> "Red";
                    case "Red" -> "Green";
                    default -> "Invalid Color";
            };
                color = newColor;
        }
        return newColor;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.foo("Green", 38));
    }
}