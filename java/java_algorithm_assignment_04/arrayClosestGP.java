public class arrayClosestGP {
    public static void main(String args[]) {
        int[] myArr = {0,1,2,3,5,6};
        System.out.println(findClosest(myArr, 7));
    }
    public static int findClosest(int[] input, int target) {
        int closest = input[0];
        int minDistance = (Math.abs(target - closest));
        for(int i = 0; i < input.length; i++) {
            int distance = Math.abs(input[i] - target);
            if(minDistance > distance) {
                closest = input[i];
                minDistance = distance;
            }

        }
        return closest;
    }
}
