import java.util.ArrayList;
import java.util.List;

public class a3_solution{
    public void trafficLights(String start, int ticks){
        // not green/yellow/red error
        if(!(start.equals("Green") || start.equals("Yellow") || start.equals("Red"))){
            System.out.println("Invalid input: " + start + " is not a recognized light color.");
            return;
        }
        // negative tick error
        if(ticks < 0){
            System.out.println("Invalid input: tick count can not be negative.");
            return;
        }

        String light = start;
        // solution
        for(int i = 0; i < ticks; i++){
            switch (light){
                case ("Green"):
                    light = "Yellow";
                    break;
                case ("Yellow"):
                    light = "Red";
                    break;
                case ("Red"):
                    light = "Green";
                    break;
                default:
                    return;
            }
        /*
            code using if/else
            if (light.equals("Green")) {
                light = "Yellow";
            }else if (light.equals("Yellow")) {
                light = "Red";
            }else{ // automatically assume light is red here
                light = "Green";
         */
        }
        System.out.println(light);
    }

    public void fullCycle(String start, int ticks){
        // not green/yellow/red error
        if(!(start.equals("Green") || start.equals("Yellow") || start.equals("Red"))){
            System.out.println("Invalid input: " + start + " is not a recognized light color.");
            return;
        }
        // negative tick error
        if(ticks < 0){
            System.out.println("Invalid input: tick count can not be negative.");
            return;
        }

        String light = start;
        List<String> list = new ArrayList<String>();
        // solution
        for(int i = 0; i < ticks; i++){
            switch (light) {
                case ("Green"):
                    light = "Yellow";
                    list.add(light);
                    break;
                case ("Yellow"):
                    light = "Red";
                    list.add(light);
                    break;
                case ("Red"):
                    light = "Green";
                    list.add(light);
                    break;
                default:

            }
        }
        System.out.println(list);
    }

    public void variableLights(String start, int ticks){
        // not green/yellow/red error
        if(!(start.equals("Green") || start.equals("Yellow") || start.equals("Red"))){
            System.out.println("Invalid input: " + start + " is not a recognized light color.");
            return;
        }
        // negative tick error
        if(ticks < 0){
            System.out.println("Invalid input: tick count can not be negative.");
            return;
        }

        String light = start;
        int tickTimer = 0;
        // solution
        for(int i = 0; i < ticks; i++) {
            switch (light) {
                case ("Green"):
                    if (tickTimer == 3) {
                        light = "Yellow";
                        tickTimer = 0;
                    } else {
                        tickTimer++;
                    }
                    break;
                case ("Yellow"):
                    light = "Red";
                    break;
                case ("Red"):
                    if (tickTimer == 2) {
                        light = "Green";
                        tickTimer = 0;
                    } else {
                        tickTimer++;
                    }
                    break;
                default:
                    System.out.println("Something went wrong.");
                    break;
            }
        }
        System.out.println(light);
    }

    public void exceptHandling(String start, int ticks) throws Exception {
        // not green/yellow/red error

        if(!(start.equals("Green") || start.equals("Yellow") || start.equals("Red"))){
            throw new Exception("Invalid input: " + start + " is not a recognized light color.");
        }
        // negative tick error
        if(ticks < 0){
            throw new Exception("Invalid input: tick count can not be negative.");
        }

        String light = start;
        // solution
        for(int i = 0; i < ticks; i++) {
            switch (light) {
                case ("Green"):
                    light = "Yellow";
                    break;
                case ("Yellow"):
                    light = "Red";
                    break;
                case ("Red"):
                    light = "Green";
                    break;
                default:
                    return;
            }
        }
    }

    public static void main(String[] args){
        a3_solution s = new a3_solution();
        s.trafficLights("Green", 0); // expect Green still
        s.trafficLights("Green", 3); // expect Green again
        s.trafficLights("Red", 5); // loop to yellow
        s.trafficLights("Green", 1); // to yellow
        s.trafficLights("Yellow", 1); // to red
        s.trafficLights("Red", 1); // to green
        s.trafficLights("White", 3); // invalid input
        s.trafficLights("Green", -1); // invalid ticks
        System.out.println("---------- Stretch Goals ----------");
        s.fullCycle("Green", 0); // should return nothing
        s.fullCycle("Green", 5);
        s.fullCycle("Red", 8);
        s.variableLights("Green", 3); // should stay green
        s.variableLights("Yellow", 4); // should go green
        s.variableLights("Red", 7); // should go yellow
        try{
            s.exceptHandling("White",3);
        }catch(Exception e){
            System.out.println("Error found: " + e.getMessage());
        }
        try{
            s.exceptHandling("Green",-11);
        }catch(Exception e){
            System.out.println("Error found: " + e.getMessage());
        }
    }
}