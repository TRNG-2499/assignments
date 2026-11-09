import java.util.Arrays;

public class algo2_solution {
    public void solution(int[] array, int k){
        int[] tempArray = new int[array.length];
        int[] callArray = array.clone();
        if(array.length == 0){
            System.out.println("Array is empty");
            return;
        }
        if(k < 0){
            System.out.println("k can not be a negative number.");
            return;
        }
        if(k == 0 || Math.abs(k)%array.length == 0){ // in the event k is zero or k is a multiple of the array length
            System.out.println(Arrays.toString(array));
            return;
        }

        for(int i = 0; i < k; i++){
            for(int j = 0; j < callArray.length; j++){
                if(j == tempArray.length-1){
                    tempArray[0] = callArray[j];
                }else{
                    tempArray[j+1] = callArray[j];
                }
            }
            callArray = tempArray;
            tempArray = new int[array.length];
        }
        System.out.println(Arrays.toString(callArray));
    }
    public static void main(String[] args) {
        algo2_solution algo2 = new algo2_solution();
        algo2.solution(new int[]{1,2,3,4,5}, 2); // expect 4,5,1,2,3
        algo2.solution(new int[]{1,2,3,4,5}, 0); // expect 1,2,3,4,5
        algo2.solution(new int[]{1,2,3,4,5}, 10); // expect 1,2,3,4,5
        algo2.solution(new int[]{}, 3); // empty array
        algo2.solution(new int[]{1,2,3,1,2,5}, 2); // dupe numbers, expect 2,5,1,2,3,1
        algo2.solution(new int[]{1,2,3,1,2,5}, -4);
    }
}
