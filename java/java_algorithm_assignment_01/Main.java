import java.util.Arrays;

public class Main {

    public static int seriesAtN(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int findMissing(int[] nums) {
        int x = 0;
        int y = 0;
        
        for (int i = 1; i <= nums.length + 1; i++) {
            x ^= i;
            if (i <= nums.length) {
                y ^= nums[i - 1];
            }
        }

        return x ^ y;
    }

    public static int findMissing(int[] nums, int start) {
        int end = nums[0];
        for (int i : nums) {
            if (i > end) {
                end = i;
            }
        }

        int x = seriesAtN(start);
        int y = seriesAtN(end);
        y -= x - start;
        
        x =
            Arrays
                .stream(nums)
                .boxed()
                .reduce(0, Integer::sum);

        int z = y - x;

        return z == 0 ? end + 1 : z;
    }

    public static int[] find2Missing(int[] nums) {
        int x = 1;
        int y = 1;
        int n = nums.length + 2;

        int k = 0;
        for (int i = 1; i <= n; i++) {
            x *= i;
            if (k < nums.length) {
                y *= nums[k++];
            }
        }

        int z = x / y;

        int a = 1;
        int b = -1;
        while (a <= n) {
            b = z / a;
            if (y * a * b == x && b <= n) {
                break;
            }
            a++;
        }

        return new int[]{a, b};
    }

    public static int[] findDupMissing(int[] nums) {
        int x = 0;
        long xp = 1;
        int y = 0;
        long yp = 1;
        int n = nums.length;

        int k = 0;
        for (int i = 1; i <= n; i++) {
            x ^= i;
            xp *= i;
            if (k < nums.length) {
                y ^= nums[k];
                yp *= nums[k++];
            }
        }

        int z = x ^ y;

        int a = 1;
        int b = -1;
        while (a <= n) {
            b = z ^ a;
            if (a != b && b >= 1 && b <= n && yp * b == xp * a) {
                break;
            }
            a++;
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int m = findMissing(new int[]{3, 7, 1, 2, 8, 4, 5});
        System.out.println(m);
        m = findMissing(new int[]{13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1});
        System.out.println(m);
        m = findMissing(new int[]{5, 6, 8, 9}, 5);
        System.out.println(m);
        m = findMissing(new int[]{5, 6, 7, 8}, 5);
        System.out.println(m);
        int[] m2 = find2Missing(new int[]{1, 2, 4, 6});
        System.out.println(Arrays.toString(m2));
        m2 = findDupMissing(new int[]{1, 2, 2, 4});
        System.out.println(Arrays.toString(m2));
    }
}
