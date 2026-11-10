import java.util.Arrays;

public class BestSoFar {
    public static void main(String... args) {
        int[] test = {4, 9, 1, 15, 8};

        System.out.println(closestMatch(test, 10));
        System.out.println(closestMatch(new int[]{5, 15}, 10));
        System.out.println(closestMatch(new int[]{}, 10));

        System.out.println(Arrays.toString(closestKMatches(test, 10, 2)));
        System.out.println(Arrays.toString(closestKMatches(test, 10, 3)));
        System.out.println(Arrays.toString(closestKMatches(new int[]{5, 15, 20}, 10, 1)));

        System.out.println(farthestMatch(test, 10));
        System.out.println(farthestMatch(test, 2));
        System.out.println(farthestMatch(new int[]{5, 15}, 10));

        System.out.println(closestMatchBiasFlag(test, 10, false));
        System.out.println(closestMatchBiasFlag(new int[]{5, 15}, 10, false));
        System.out.println(closestMatchBiasFlag(new int[]{5, 15}, 10, true));
    
    
    }

    public static int closestMatch(int[] ints, int target) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        selectionSortByMinDelta(ints, target, 1, false);
        
        return ints[0];
    }

    public static int[] closestKMatches(int[] ints, int target, int k) {
        if (ints == null || ints.length == 0) {
            return new int[] {-1};
        }
        selectionSortByMinDelta(ints, target, k, false);
        
        return Arrays.copyOfRange(ints, 0, k);
    }

    public static int farthestMatch(int[] ints, int target) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        selectionSortByMaxDelta(ints, target, 1, false);
        
        return ints[0];
    }

    public static int closestMatchBiasFlag(int[] ints, int target, boolean bias) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        selectionSortByMinDelta(ints, target, 1, bias);
        
        return ints[0];
    }


    public static void selectionSortByMinDelta(int[] ints, int target, int k, boolean bias) {
        
        k = Math.max(0,Math.min(k, ints.length));
        for (int i = 0; i < k; i++) {
            int minDelta = i;
            for (int j = i + 1; j < ints.length ; j++) {
                if (Math.abs(target - ints[j]) < Math.abs(target - ints[minDelta])) {
                    minDelta = j;
                } else if (Math.abs(target - ints[j]) == Math.abs(target - ints[minDelta])) {
                    minDelta = bias?((ints[j]>ints[minDelta])?j:minDelta):((ints[j]<ints[minDelta])?j:minDelta);
                    //completely unreadable nested tertiary but basically
                    //on-lines the bias functionality for tie-breaking.
                }
            }

            int tmp = ints[i];
            ints[i] = ints[minDelta];
            ints[minDelta] = tmp;
        }

    }

    public static void selectionSortByMaxDelta(int[] ints, int target, int k, boolean bias) {
        k = Math.min(k, ints.length);
        for (int i = 0; i < k; i++) {
            int maxDelta = i;
            for (int j = i + 1; j < ints.length ; j++) {
                if (Math.abs(target - ints[j]) > Math.abs(target - ints[maxDelta])) {
                    maxDelta = j;
                } else if (Math.abs(target - ints[j]) == Math.abs(target - ints[maxDelta])) {
                    maxDelta = bias?((ints[j]>ints[maxDelta])?j:maxDelta):((ints[j]<ints[maxDelta])?j:maxDelta);
                    //completely unreadable nested tertiary but basically
                    //on-lines the bias functionality for tie-breaking.
                }
            }

            int tmp = ints[i];
            ints[i] = ints[maxDelta];
            ints[maxDelta] = tmp;
        }

    }

}