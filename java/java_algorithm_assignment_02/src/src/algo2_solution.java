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

    public void toLeft(int[] array, int k){
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
                if(j == 0){
                    tempArray[tempArray.length-1] = callArray[j];
                }else{
                    tempArray[j-1] = callArray[j];
                }
            }
            callArray = tempArray;
            tempArray = new int[array.length];
        }
        System.out.println(Arrays.toString(callArray));
    }
    public void negativeInclude(int[] array, int k){
        int[] tempArray = new int[array.length];
        int[] callArray = array.clone();
        if(array.length == 0){
            System.out.println("Array is empty");
            return;
        }
        if(k < 0){
            toLeft(array, Math.abs(k));
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
    public void noExtra(int[] array, int k){
        k = k%array.length; // found that normalizing is just better than the method I used earlier.
        int tempNumber;
        for(int i = 0; i < array.length/2; i++){ // reverse everything first
            tempNumber = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = tempNumber;
        }
        for(int i = 0; i < k/2; i++){ // reverse only up until k
            tempNumber = array[i];
            array[i] = array[k-i-1];
            array[k-i-1] = tempNumber;
        }
        int j = 0;
        for(int i = k; i < array.length-1; i++){ // reverse after k
            if(i >= array.length-1-j){
                break;
            }
            tempNumber = array[i];
            array[i] = array[array.length-1-j];
            array[array.length-1-j] = tempNumber;
            j++;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        algo2_solution algo2 = new algo2_solution();
        algo2.solution(new int[]{1,2,3,4,5}, 2); // expect 4,5,1,2,3
        algo2.solution(new int[]{1,2,3,4,5}, 0); // expect 1,2,3,4,5
        algo2.solution(new int[]{1,2,3,4,5}, 10); // expect 1,2,3,4,5
        algo2.solution(new int[]{}, 3); // empty array
        algo2.solution(new int[]{1,2,3,1,2,5}, 2); // dupe numbers, expect 2,5,1,2,3,1
        algo2.solution(new int[]{1,2,3,1,2,5}, -4); // this one does nothing
        System.out.println("---------- Stretch Goals ----------");
        algo2.toLeft(new int[]{1,2,3,4,5}, 2); // expect 3,4,5,1,2
        algo2.toLeft(new int[]{1,2,3,4,5}, 0); // expect same
        algo2.toLeft(new int[]{1,2,3,4,5}, 8); // expect 4,5,1,2,3
        algo2.negativeInclude(new int[]{1,2,3,4,5}, -2); // expect 3,4,5,1,2
        algo2.negativeInclude(new int[]{1,2,3,4,5}, 2); // expect 4,5,1,2,3
        algo2.negativeInclude(new int[]{1,2,3}, -7); // expect 2,3,1
        algo2.noExtra(new int[]{1,2,3,4,5}, 2); // expect 4,5,1,2,3
        algo2.noExtra(new int[]{1,2,3,4,5,6}, 1); // expect 6,1,2,3,4,5
        algo2.noExtra(new int[]{6,5,4,3,2,1}, 7); // expect 1,6,5,4,3,2
    }
}
