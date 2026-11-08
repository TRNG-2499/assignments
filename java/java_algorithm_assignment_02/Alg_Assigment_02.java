import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alg_Assigment_02 {
    
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 3, 4};

        System.out.println("Input: " + Arrays.toString(arr1) + ", k = "+ 2);
        System.out.println("Output:" + Arrays.toString(rotateArray(arr1, 2)));

        System.out.println("Input: " + Arrays.toString(arr2) + ", k = "+ 4);
        System.out.println("Output:" + Arrays.toString(rotateArray(arr2, 4)));

        System.out.println("Input: " + Arrays.toString(arr3) + ", k = "+ 0);
        System.out.println("Output:" + Arrays.toString(rotateArray(arr3, 0)));



        System.out.println("\n=== 2. Rotate Left ===");
        int[] leftInput = {1, 2, 3, 4, 5};
        int kLeft = 2;
        System.out.println("Input: " + Arrays.toString(leftInput) + ", k = "+ kLeft);
        System.out.println("Output: " + Arrays.toString(rotateLeft(leftInput, kLeft)));


        System.out.println("\n=== 3. Negative Step Counts ===");
        int[] signInput = {1, 2, 3, 4, 5};
        
        // Positive k (Right)
        System.out.println("Input: " + Arrays.toString(signInput) + ", k = "+ 2);
        System.out.println("Output: " + Arrays.toString(rotateWithSign(signInput, 2)));

        // Negative k (Left by 2)
        System.out.println("Input: " + Arrays.toString(signInput) + ", k = "+ -2);
        System.out.println("Output: " + Arrays.toString(rotateWithSign(signInput, -2))); // [3, 4, 5, 1, 2]

        // Large negative k (-7 on length 5 => Left by 2)
        System.out.println("Input: " + Arrays.toString(signInput) + ", k = "+ -7);
        System.out.println("Output: " + Arrays.toString(rotateWithSign(signInput, -7))); // [3, 4, 5, 1, 2]


        System.out.println("\n=== 4. Minimal Extra Memory (In-Place) ===");
        
        // Test In-Place Right Rotation
        int[] inPlaceInput = {1, 2, 3, 4, 5};
        int kInPlace = 2;
        System.out.print("Before: " + Arrays.toString(inPlaceInput));
        rotateInPlace(inPlaceInput, kInPlace);
        System.out.println("\nAfter : " + Arrays.toString(inPlaceInput)); // [4, 5, 1, 2, 3]

        // Test In-Place Negative Rotation (Left by 3)
        int[] inPlaceInput2 = {1, 2, 3, 4, 5};
        System.out.println("\nBefore: " + Arrays.toString(inPlaceInput2) + ", k = "+ -3);
        rotateInPlace(inPlaceInput2, -3); 
        System.out.println("After : " + Arrays.toString(inPlaceInput2)); 



    }
        
        
    


    public static int[] rotateArray(int[] input, int count) {

        // convert pimitive int[] -> Interger[]
        Integer[] boxed = Arrays.stream(input).boxed().toArray(Integer[]::new );
        // Warp it ina list
        List<Integer> list = Arrays.asList(boxed);
        // doing the rotation
        Collections.rotate(list, count);
        // convert back to Interger[]
        Integer[] rotated = list.toArray(new Integer[0]);

        // Interger[] -> primtive int[]
        return Arrays.stream(rotated).mapToInt(Integer::intValue).toArray();

    }   

    public static int[] rotateLeft(int[] input, int count) {
        if (input == null || input.length == 0 || count == 0) {
            return input;
        }

        Integer[] boxed = Arrays.stream(input).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(boxed);
        Collections.rotate(list, -count); // negative k -> left rotation
        Integer[] rotated = list.toArray(new Integer[0]);
        return Arrays.stream(rotated).mapToInt(Integer::intValue).toArray();
    }

    public static int[] rotateWithSign(int[] input, int count) {
        if (input == null || input.length == 0 || count == 0) {
            return input;
        }

        Integer[] boxed = Arrays.stream(input).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(boxed);
        Collections.rotate(list, count); // positive -> right, negative -> left
        Integer[] rotated = list.toArray(new Integer[0]);
        return Arrays.stream(rotated).mapToInt(Integer::intValue).toArray();

    }

    public static void rotateInPlace(int[] input, int count) {

        if (input == null || input.length <= 1 || count == 0) {
            return;
        }

        int n = input.length;
        int k = Math.abs(count % n); // normalize to [0, n-1]

        reverse(input, 0, n - 1); // reverse entire array
        reverse(input, 0, k - 1); // reverse first k elements
        reverse(input, k, n - 1); //  reverse first k elements
        
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
            
        }
    }


}
