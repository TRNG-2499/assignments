public class Main {

    public static void trafficLightSim(String startColor, int numTicks){

        if(startColor == "Green" || startColor == "Yellow" || startColor == "Red"){
            if(numTicks>=0){

                numTicks = numTicks % 3;

                while(numTicks>0){
                    switch(startColor){
                        case "Green":
                            startColor="Yellow";
                            numTicks--;
                            break;
                        case "Yellow":
                            startColor="Red";
                            numTicks--;
                            break;
                        case "Red":
                            startColor="Green";
                            numTicks--;
                            break;
                    }
                }

                System.out.println(startColor + "\n");

            } else {
                //Case where the number of ticks is negative
                System.out.println("Invalid Input: tick count cannot be negative.\n");
            }
        } else {
            //Case where starting color is unrecognized
            System.out.println("Invalid Input: " + startColor + " is not a recognized light color.\n");
        }

    }

    public static void main(String[] args) {

        //Single Tick
        System.out.println("startColor = Green, numTicks=1");
        trafficLightSim("Green", 1);

        //Full cycle returns to the same color
        System.out.println("startColor = Green, numTicks=3");
        trafficLightSim("Green", 3);

        //Multiple cycles plus a remainder
        System.out.println("startColor = Red, numTicks=5");
        trafficLightSim("Red", 5);

        //Zero Ticks -> No change
        System.out.println("startColor = Green, numTicks=0");
        trafficLightSim("Green", 0);

        //Unrecognized Starting color
        System.out.println("startColor = Orange, numTicks=1");
        trafficLightSim("Orange", 1);

        //Negative Tick Count
        System.out.println("startColor = Green, numTicks=-1");
        trafficLightSim("Green", -1);
    }
}