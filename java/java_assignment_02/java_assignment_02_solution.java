import java.util.Arrays;

public class java_assignment_02_solution {
    // Elevator Weight Limit Checker

    // Params weight, list

    public static void main(String[] args) {

        // overload, exact match = overload
        // safe boarding

        int[] Board1 = {200, 200, 200};
        int[] Board2 = {};
        int [] Board3 = {100, 200, 300, 400, 999};

        Boarding(Board1, 650);
        Boarding(Board1, 600);
        Boarding(Board1, 150);
        Boarding(Board2, 400);

    }

    public static void Boarding(int[] Passengers, int Limit) {

        int load = 0;

        String input = String.format("Input: Weight Limit %d. Passengers = %s", Limit, Arrays.toString(Passengers));
        System.out.println(input);

        if(Passengers.length == 0){
            System.out.println("There are no passengers to board.");
        }
        else{

        for (int i = 0; i < Passengers.length; i++) {
            load += Passengers[i];
            if (load >= Limit) {
                String result = String.format("Passenger %d caused an overload. Total weight at that point: %d", i+1, load);
                System.out.println(result);

                break;
            }
        }
        if (load < Limit) {
            String result = String.format("All passengers boarded safely. Total weight: %d", load);
            System.out.println(result);
        }
    }

    }
}