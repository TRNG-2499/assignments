import java.util.Arrays;

public class RotateArray {

    // Very unoptimal solution yes
    public static int[] Solution(int[] intArray, int k) {
        int shifts = k;

        int[] shiftedArray = intArray.clone();
        while (shifts > 0) {
            int lastElement = shiftedArray[shiftedArray.length - 1];

            int[] newArray = shiftedArray.clone();
            
            for (int i = 0; i < shiftedArray.length - 1; i++) {
                newArray[i+1] = shiftedArray[i];
            }
            newArray[0] = lastElement;
            shiftedArray = newArray;
            shifts -= 1;
        }

        return shiftedArray;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution(new int[] {1, 2, 3}, 0)));
    }
}
