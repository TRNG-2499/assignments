import java.util.Arrays;

public class algo4_solution {
    public int solution(int[] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }
        int currClosest = array[0];
        for(int num : array){
            if(Math.abs(target-num) < Math.abs(target - currClosest)){
                currClosest = num;
            }
            if(Math.abs(target-num) == Math.abs(target - currClosest)){
                if(num < currClosest){
                    currClosest = num;
                }
            }
        }
        return currClosest;
    }
    public int[] closestK(int[] array, int target, int k){
        /*
        unsure of edge cases. what to do if k > array length?
        should list be sorted by how close they are? or just lowest to highest?
        assuming i will drop the farthest number with the newest one
         */
        if(array == null || array.length == 0){
            return new int[]{-1};
        }
        boolean recalibrate = false;
        int[] result = new int[k];

        int currFarthest = array[0];
        int farthestPosition = 0;
        for(int i = 0; i < k; i++){ // probably easier to parse when looking at this?
            result[i] = array[i];
            if(Math.abs(target-result[i]) > Math.abs(target - currFarthest)){
                currFarthest = result[i];
                farthestPosition = i;
            }
        }

        for(int i = k; i < array.length; i++){
            if(Math.abs(target-array[i]) < Math.abs(target - currFarthest)){
                result[farthestPosition] = array[i];
                currFarthest = array[i];
                for(int j = 0; j < k; j++){
                    if(Math.abs(target-result[j]) > Math.abs(target - currFarthest)){
                        currFarthest = result[j];
                        farthestPosition = j;
                    }
                }
            }
        }
        Arrays.sort(result); // just to sort lowest to highest i suppose
        return result;
    }
    public int farthest(int[] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }
        int currFarthest = array[0];
        for(int num : array){
            if(Math.abs(target-num) > Math.abs(target - currFarthest)){
                currFarthest = num;
            }
            if(Math.abs(target-num) == Math.abs(target - currFarthest)){
                if(num < currFarthest){
                    currFarthest = num;
                }
            }
        }
        return currFarthest;
    }
    public int highLow(int[] array, int target, boolean flag){
        if(array == null || array.length == 0){
            return -1;
        }
        int currClosest = array[0];
        for(int num : array){
            if(Math.abs(target-num) < Math.abs(target - currClosest)){
                currClosest = num;
            }
            if(Math.abs(target-num) == Math.abs(target - currClosest)){
                if(flag){
                    if(num > currClosest){
                        currClosest = num;
                    }
                }else{
                    if(num < currClosest){
                        currClosest = num;
                    }
                }
            }
        }
        return currClosest;
    }
    public static void main(String[] args) {
        algo4_solution algo4 = new algo4_solution();
        System.out.println(algo4.solution(null, 6)); // expect -1
        System.out.println(algo4.solution(new int[]{}, 6)); // expect -1
        System.out.println(algo4.solution(new int[]{4,9,1,15,8},10)); // expect 9
        System.out.println(algo4.solution(new int[]{5,15},10)); // expect 5, lowest of tie
        System.out.println(algo4.solution(new int[]{4,9,1,15,8},2)); // expect 1
        System.out.println("---------- Stretch Goals ----------");
        System.out.println(Arrays.toString(algo4.closestK(new int[]{1, 2, 3, 4, 5}, 10, 3)));
        System.out.println(Arrays.toString(algo4.closestK(new int[]{87, 11, 20, 40, 33}, 10, 3))); // expect 11, 20, 33
        System.out.println(algo4.farthest(new int[]{4,9,1,15,8},10)); // expect 1
        System.out.println(algo4.farthest(new int[]{2,3,4,5},1)); // expect 5
        System.out.println(algo4.farthest(new int[]{5,15},10)); // expect 5, still lowest tie
        System.out.println(algo4.highLow(new int[]{1,19},10, false)); // expect 5, still lowest tie
        System.out.println(algo4.highLow(new int[]{1,19},10, true)); // expect 15, now highest tie
        System.out.println(algo4.highLow(new int[]{1,11,100},10, false)); // expect 11, show still works
        System.out.println(algo4.highLow(new int[]{1,11,100},10, true)); // expect 11, show still works
    }
}
