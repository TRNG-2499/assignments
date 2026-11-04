public class elevator_GP {
    public static void main(String[] args) {

        int[] ppl1 = {101,2,3};

        System.out.println(elevator(100, ppl1));
    }

    public static String elevator(int max, int[] ppl) {
        int currentW = 0;

        for(int i = 0; i < ppl.length; i++) {
            currentW = ppl[i] + currentW;
            if (currentW >= max) {
                return "Maximum weight exceeded! Passenger "+(i + 1)+" exceeded capacity! Elevator weight at " + (currentW);

            }
        }
        return "Everyone was able to get on :) Total weight is "+currentW;
    }
}
