public class ClosestValueInArray {

    public static void main(String[] args) {
        int [] myArr = {13,1,3,4,7};
        int myTarget = 10;
        int close = closestValueInArray(myArr, myTarget);
        System.out.println(close);
    }
    public static int closestValueInArray(int [] arr, int target){
        if (arr == null) {
            return -1;
        }

        int closest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            //use Math.abs because I was recommended it by an LLM
            int currentDistance = Math.abs(target - arr[i]);
            int closestDistance = Math.abs(target - closest);

            //if the new number is closer
            if (currentDistance < closestDistance) {
                closest = arr[i];
            }
            // It tied so pick the smaller value
            else if (currentDistance == closestDistance && arr[i] < closest) {
                closest = arr[i];
            }
        } return closest;

    }
}
