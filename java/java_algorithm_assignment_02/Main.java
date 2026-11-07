import java.util.Arrays;

public class Main {

    public static int[] rotateArray(int[] array, int k){
        int[] rotatedArray = new int[array.length];

        if(k!=0){
            if(k>array.length){
                k = k % array.length;
            }

            for(int i = 0; i < array.length; i++){
                //i+k handles indexes that don't wrap, i+k-array.length handles indexes that do wrap
                rotatedArray[i+k < array.length ? i+k : (i+k)-array.length] = array[i];
            }
        } else {
            rotatedArray = array;
        }

        return rotatedArray;
    }

    public static void main(String[] args){
        //Test 1: k < array length
        System.out.println("Input: [1, 2, 3, 4, 5], k=2");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateArray(arr1, 2)));

        //Test 2: k > array length
        System.out.println("Input: [1, 2, 3], k=4");
        int[] arr2 = {1, 2, 3};
        System.out.println(Arrays.toString(rotateArray(arr2, 4)));

        //Test 3: k = array length
        System.out.println("Input: [1, 2, 3, 4], k=4");
        int[] arr3 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(rotateArray(arr3, 4)));

        //Test 4: k = 0
        System.out.println("Input: [1, 2, 3, 4], k=0");
        int[] arr4 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(rotateArray(arr4, 0)));

    }
}
