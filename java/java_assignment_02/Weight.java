package java.java_assignment_02;

public class Weight {
    public static String weight_limit (double limit, double[] weight){
        if (weight == null || weight.length == 0) {
            return "No passengers to board.";
        }
        double total = 0;
        for (int i = 0; i< weight.length; i++){
            total += weight[i];
            if (total >= limit){
                return "Weight limit of " + limit + " exceeded because of: " + (i + 1) + " Total wieght is: " + total;
            }
        }
        return "All aboard!";
    }
    public static void main(String[] args){
        System.out.println(weight_limit(500, new double[]{150,200, 180, 90}));
        System.out.println(weight_limit(500, new double[]{150,100, 120}));
        System.out.println(weight_limit(500, new double[]{}));
    }
}
