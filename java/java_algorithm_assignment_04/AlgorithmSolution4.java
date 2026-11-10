import java.util.PriorityQueue;
import java.util.Map;
public class AlgorithmSolution4 {
    public static void main(String[] args) {
        System.out.println(closestValue(new int[]{}, 2));
        int[] test = kClosest(new int[]{4, 9, 1, 15, 8}, 2, 3);
        for(int v : test)
            System.out.println(v); 
    }

    public static int closestValue(int[]arr, int target){
        if(arr.length == 0)
            return -1;
        int closestIdx = -1;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            int diff = Math.abs(arr[i] - target);
            if((diff < minDiff) || (diff == minDiff && closestIdx > -1 && arr[closestIdx] > arr[i])){
                minDiff = diff;
                closestIdx = i;
            }
        }

        return arr[closestIdx];
    }

    //Stretch Goal Closest K values
    public static int[] kClosest(int[]arr, int target, int k){
        if(arr.length == 0)
            return arr;

        //entry<diff, value>
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByKey());

        for(int i = 0; i < arr.length; i++){
            int diff = Math.abs(arr[i] - target);
            Map.Entry<Integer, Integer> entry = Map.entry(diff, arr[i]);
            minHeap.offer(entry);
        }

        int [] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = minHeap.poll().getValue();

        return res;
    }
}
