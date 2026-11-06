public class traffic {

    public String lights(String color, int tickCount) {
        int count = 0;
        if (tickCount < 0) {
            return "Invalid input: tick count cannot be negative.";
        }
        if (color == "green" || color == "yellow" || color == "red") {         
            if (color == "yellow") {
                count = 1;
            }
            else if (color == "red") {
                count = 2;
            }
            else if (color == "green") {
                count = 0;
            }    
        int cycle = (tickCount + count) % 3;
        switch(cycle) {
            case 1:
                color = "yellow";
                return color;
            case 2:
                color = "red";
                return color;
            case 0:
                color = "green";
                return color;


        }
        }
        else {
            return "Invalid input: 'Purple' is not a recognized light color.";
        }
        return color;
    }
    public static void main(String [] args) {
        traffic tv = new traffic();
        System.out.println(tv.lights("green", 1));
        System.out.println(tv.lights("green", 3));
        System.out.println(tv.lights("red", 5));
        System.out.println(tv.lights("green", 0));
    
    }
}