public class Main {
    String track_overload(double weight_limit, double[] arr) {
        if(arr.length <= 0) { return "exception: empty or negative passenger list size"; }


        double running_total = 0;
        for(int i = 0; i < arr.length; i++) {
            if(running_total + arr[i] >= weight_limit) {
                return "Cannot add Passenger " + i+1 + " with weight of " + arr[i] + " as it would cause an overload and resaulting weight of: " + running_total;
            } else {
                running_total += arr[i];
            }
        }
        return "All passengers added succesfully without weight overload. Total weight of passengers: " + running_total;
    }

    public static void main(String[] args) {
        double ex_limit = 750;
        double[] ex_weights = {
                105.5, 120.3, 135.7, 150.2, 175.8,
                200.4, 225.6, 250.1, 275.9, 300.5
        };
        Main obj = new Main();
        System.out.println(obj.track_overload(ex_limit, ex_weights));
    }
}