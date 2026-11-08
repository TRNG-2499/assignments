import java.util.Arrays;

public class MissingNumber {
    public static void main(String... args) {
        System.out.println(missingNumber(3, 2, 5, 4));    // 1
        System.out.println(missingNumber(3, 1, 4, 2));    // 5
        System.out.println(missingNumber(5, 4, 1, 2, 2)); // 3

        System.out.println(missingFromStart(2, 5, 6, 3, 4, 2)); // 7
        System.out.println(missingFromStart(2, 7, 6, 3, 4, 5)); // 2
        System.out.println(missingFromStart(2, 3, 4, 2, 7, 6)); // 5
        System.out.println(missingFromStart(1, 3, 2, 5, 4));    // 1
        System.out.println(missingFromStart(1, 3, 1, 4, 2));    // 5
        System.out.println(missingFromStart(1, 5, 4, 1, 2));    // 3

        System.out.println(Arrays.toString(missingAndDuplicate(1, 2, 2, 4))); // [3, 2]

        System.out.println(Arrays.toString(twoMissingNumbers(5, 6, 3, 4, 2))); // [1, 7]
        System.out.println(Arrays.toString(twoMissingNumbers(7, 6, 3, 4, 5))); // [1, 2]
        System.out.println(Arrays.toString(twoMissingNumbers(3, 4, 2, 7, 6))); // [1, 5]
    }

    public static int missingNumber(int... numbers) {
        return missingFromStart(1, numbers);
    }
    

    public static int missingFromStart(int start, int... numbers) {
        if (numbers == null || numbers.length == 0) return start;
        Arrays.sort(numbers);

        if (numbers[0] != start) return start;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > (numbers[i-1] + 1)) return numbers[i] - 1;
        }
        
        return start + numbers.length; 
    }

    public static int[] twoMissingNumbers(int... numbers) {
        int firstMissing = missingFromStart(1, numbers);
        int[] out = {firstMissing, 0};
        int[] remainingNumbers = Arrays.copyOfRange(numbers, firstMissing - 1, numbers.length);
        out[1] = missingFromStart(firstMissing + 1, remainingNumbers);

        return out;
    }

    public static int[] missingAndDuplicate(int... numbers) {
        int missing = missingFromStart(1, numbers);
        int duplicate = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == (numbers[i-1])) duplicate = numbers[i];
        }

        int[] out = {missing, duplicate};
        return out;
    }
}