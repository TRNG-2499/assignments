

public class weightchecker {

    public String check(int weight, int [] arr) {
        int total = 0;
        for (int i =0; i<arr.length;i++) {
            total +=arr[i];
            int check = weight-total;   
            if (check <=0) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + total + " lbs.";
            }
        }
        return "All passengers are within the weight limit.";
    }
    public static void main(String[]args) {
        System.out.println("Welcome to the Weight Checker!");
        weightchecker wc = new weightchecker();
        int[] weights1 = {150, 200, 100, 50};
        System.out.println(wc.check(1500, weights1));
        int[] weights2 = {150, 200, 100, 75};
        System.out.println(wc.check(500, weights2));
        System.out.println(wc.check(500, new int[]{200, 300}));
        System.out.println(wc.check(1000, new int[]{150, 200, 300, 250, 180}));
    }
}