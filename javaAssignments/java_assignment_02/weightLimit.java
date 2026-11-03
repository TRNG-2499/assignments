package javaAssignments.java_assignment_02;

public class weightLimit {
    
    public static void main(String[] args) {
        //TEST STATEMENTS
        /* 
        System.out.println(overloadCheck(new double[]{50.0, 50.0, 50.0}, 200.0));
        System.out.println(overloadCheck(new double[]{100.0, 20.0, 50.0, 100.0}, 200.0));
        System.out.println(overloadCheck(new double[]{0.0, 100000.0, 0.0}, 200.0));
        System.out.println(overloadCheck(new double[]{}, 200.0));
        System.out.println(overloadCheck(new double[]{100.0, 100.0}, 200.0));
        */
    }

    //checking for overload
    public static String overloadCheck(double[] weights, double limit) {
        //checking for empty passengers
        if (weights.length == 0){
            return "No passengers to check.";
        }
        //calculating total weight and checking for overload
        double totalWeight = 0.0;
        //using a for loop to iterate through each passenger's weight and add it to the total weight
        for (int i = 0; i < weights.length; i++) {
            double weight = weights[i];

            //increases total weight
            totalWeight += weight; 

            //checking for overload
            if (totalWeight >= limit) {
                //Added a + 1 because humans don't think in terms of 0-indexing
                return "Overloaded. Overloaded at passenger " + (i + 1);
            }
        }
        return "Within limit, all passengers boarded safely. Total weight: " + totalWeight + ", Limit: " + limit;
    }
}
