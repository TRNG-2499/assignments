import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

public class MissingNumberFinder {

    public static int Solution(int[] intArray) {
        int result = 0;

        HashSet<Integer> intSet = new HashSet<Integer>();
        for (int v : intArray) {
            intSet.add(v);
        }

        int n = intArray.length + 1;
        for (int i = 1; i <= n; i++) {
            if (!intSet.contains(i)) {
                result = i;
                break;
            }
        }
        return result;
    }


    public static int Solution2(int[] intArray, int start) {
        int result = 0;
        int n = start + intArray.length;

        HashSet<Integer> intSet = new HashSet<Integer>();
        for (int v : intArray) {
            intSet.add(v);
        }

        for (int i = start; i <= n; i++) {
            if (!intSet.contains(i)) {
                result = i;
                break;
            }
        }
        return result;
    }


    public static int[] Solution3(int[] intArray) {
        int[] result = new int[2];
        int n = intArray.length + 2;

        HashSet<Integer> intSet = new HashSet<Integer>();
        for (int v : intArray) {
            intSet.add(v);
        }

        int resultIdx = 0;
        for (int i = 1; i <= n; i++) {
            if (resultIdx == 2) {
                break;
            }

            if (!intSet.contains(i)) {
                result[resultIdx] = i;
                resultIdx += 1;
            }
        }

        return result;
    }


    public static HashMap<String, Integer> Solution4(int[] intArray) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        int n = intArray.length;

        HashSet<Integer> intSet = new HashSet<Integer>();

        for (int v : intArray) {
            intSet.add(v);
        }

        for (int i = 1; i <= n; i++) {
            if (!intSet.contains(i)) {
                result.put("Missing", i);
                break;
            }
        }

        HashSet<Integer> fillSet = new HashSet<Integer>();
        for (int v : intArray) {
            if (!fillSet.contains(v)) {
                fillSet.add(v);
            } else {
                result.put("Duplicate", v);
                break;
            }
        }

        return result;
    }


    public static void test1(int[] input) {
        int result = Solution(input);
        System.out.println(result);
    }

    public static void test2(int[] input) {
        int result = Solution(input);
        System.out.println(result);
    }

    public static void main(String[] args) {
        test1(new int[] {3, 7, 1, 2, 8, 4, 5});
        test2(new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1});

        System.out.println(Solution2(new int[] {5, 6, 8, 9}, 5)); 

        String r3 = Arrays.toString(Solution3(new int[] {1, 2, 4, 6}));
        System.out.println(r3);

        HashMap<String, Integer> r4 = Solution4(new int[] {1, 2, 2, 4});
        System.out.println(r4);
    }
}