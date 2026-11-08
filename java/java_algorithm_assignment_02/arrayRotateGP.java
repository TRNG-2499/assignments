import java.util.Arrays;

public class arrayRotateGP {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6};
        System.out.println(rotate(arr, 2));
    }
    public static String rotate(int[] numbers, int step) {

        int[] temp = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            temp[(i + step)%numbers.length] = numbers[i];
        }

        return Arrays.toString(temp);
    }
}
