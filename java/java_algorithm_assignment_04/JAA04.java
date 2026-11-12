package java_algorithm_assignment_04;

public class JAA04 {
    public static int findClosest(int[] arr, int tgt){
        if (arr == null || arr.length == 0){
            return -1;
        }

        int minDiff = Integer.MAX_VALUE;
        int closest = arr[0];

        for (int val : arr){
            if (Math.abs(tgt - val) < minDiff){
                closest = val;
                minDiff = Math.abs(tgt - val);
            } else if (Math.abs(tgt - val) == minDiff){
                closest = Math.abs(tgt - minDiff);
            }
        }

        return closest;
    }
    public static void main(String[] args){
        int[] in = {5,15};
        int target = 10;

        int result = findClosest(in, target);
        System.out.println(result);
    }
}
