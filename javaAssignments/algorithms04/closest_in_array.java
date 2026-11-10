package javaAssignments.algorithms04;

public class closest_in_array {

    public static void main(String[] args) {
        // System.out.println(closest(new int[]{1, 2, 3, 4, 5}, 3));
        // System.out.println(closest(new int[]{1, 2, 3, 4, 5}, 8));
        // System.out.println(closest(new int[]{}, 3));
        // System.out.println(furthest(new int[]{1, 2, 3, 4, 5}, 3));
        // System.out.println(furthest(new int[]{1, 2, 3, 4, 5}, 8));
        // System.out.println(furthest(new int[]{}, 3));
        // System.out.println(closestFlagged(new int[]{1, 2, 4, 5}, 3, true));
        // System.out.println(closestFlagged(new int[]{1, 2, 4, 5}, 3, false));
        // System.out.println(java.util.Arrays.toString(closestK(new int[]{1, 2, 3, 4, 5}, 3, 2)));
        // System.out.println(java.util.Arrays.toString(closestK(new int[]{1, 2, 3, 4, 5}, 3, 3)));
        // System.out.println(java.util.Arrays.toString(closestK(new int[]{1, 2, 3, 4, 5}, 3, 5)));
        // System.out.println(java.util.Arrays.toString(closestK(new int[]{}, 3, 1)));
    }
    
    public static int closest(int[] arr, int target) {
        int closest = -1; //initialize the closest value to -1, if the array is empty it will never modify and return -1
        for (int num : arr) { //iterate through the array
            if (closest == -1 || Math.abs(num - target) < Math.abs(closest - target)) { //check if the distance between current num + target is greater OR if closest is our default
                closest = num;
            }
        }
        return closest;
    }


    //closest K values
    public static int[] closestK(int[] arr, int target, int k) {
        //iterate through the array, find the closest value, then remove that value and repeat the process
        int[] result = new int[k];
        int[] temp = arr.clone(); //create a temporary copy of the array to avoid modifying the original
        for (int i = 0; i < k; i++) {
            int closest = closest(temp, target);
            if (closest == -1) { //if no more elements are left or array is empty, break the loop
                result = new int[]{-1}; //keeps the consistency of empty arrays returning [-1]
                break;
            }
            result[i] = closest;
            temp = removeElement(temp, closest);
        }
        return result;
    }

    //helper method to remove an element from the array
    private static int[] removeElement(int[] arr, int element) { //returns a new array with the specified element removed
        int[] result = new int[arr.length - 1];
        int index = 0;
        for (int num : arr) {
            if (num != element) {
                result[index++] = num;
            }
        }
        return result;
    }

    //farthest value
    public static int furthest(int[] arr, int target) {
        int furthest = -1; //initialize the furthest value to -1, if the array is empty it will never modify and return -1
        for (int num : arr) { //iterate through the array
            if (furthest == -1 || Math.abs(num - target) > Math.abs(furthest - target)) { //check if the distance between current num + target is greater OR if furthest is our default
                furthest = num;
            }
        }
        return furthest;
    }

    //higher/lower flag tiebreaker
    public static int closestFlagged(int[] arr, int target, boolean higher) {
        int closest = -1; //initialize the closest value to -1, if the array is empty it will never modify and return -1
        for (int num : arr) { //iterate through the array
            if (closest == -1 || Math.abs(num - target) < Math.abs(closest - target) || (Math.abs(num - target) == Math.abs(closest - target) && higher && num > closest)) { //check if the distance between current num + target is greater OR if closest is our default
                closest = num;  //just adds another check that if they are equal, spit out the higher value if the flag is true
            }
        }
        return closest;
    }
}
