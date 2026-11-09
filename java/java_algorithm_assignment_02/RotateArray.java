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


    // Stretch goal #1
    // A bit of a step up in efficiency compared to first solution
    public static int[] Solution2(int[] intArray, int k) {
        int idxOffset = k % intArray.length;

        int[] newArray = new int[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            int newIdxPos = i - idxOffset;
            if (newIdxPos < 0) {
                newIdxPos = newArray.length + newIdxPos;    // handles wrap-arounds
            }
            newArray[newIdxPos] = intArray[i];
        }

        return newArray;
    }


    // Stretch goal #2
    public static int[] Solution3(int[] intArray, int k) {
        int idxOffset = -k % intArray.length;

        int[] newArray = new int[intArray.length];

        if (k >= 0) {
            for (int i = 0; i < intArray.length; i++) {
                int newIdxPos = i + idxOffset;
                if (newIdxPos > newArray.length - 1) {
                    newIdxPos = newIdxPos - newArray.length;
                }
                newArray[newIdxPos] = intArray[i];
            }

        } else {
            for (int i = 0; i < intArray.length; i++) {
                int newIdxPos = i - idxOffset;
                if (newIdxPos < 0) {
                    newIdxPos = newArray.length + newIdxPos; 
                }
                newArray[newIdxPos] = intArray[i];
        }
        }

        return newArray;
    }

    
    public static void inPlaceReverse(int[] intArray, int lp, int rp) {
        while (lp < rp) {
            int leftVal = intArray[lp];
            intArray[lp] = intArray[rp];
            lp += 1;

            intArray[rp] = leftVal;
            rp -= 1;
        }
    }


    // Stretch goal #3
    // Reverse all elements, then reverse 0 to k elements, then reverse the remaining elements
    // Very unintuitive solution indeed
    public static int[] Solution4(int[] intArray, int k) {
        int moddedK = k % intArray.length;
        int lp = 0;
        int rp = intArray.length - 1;
        inPlaceReverse(intArray, lp, rp);

        lp = 0;
        rp = moddedK - 1;
        inPlaceReverse(intArray, lp, rp);
        
        lp = moddedK;
        rp = intArray.length - 1;
        inPlaceReverse(intArray, lp, rp);

        return intArray;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution(new int[] {1, 2, 3}, 0)));

        System.out.println(Arrays.toString(Solution2(new int[] {1, 2, 3, 4, 5}, 7)));

        System.out.println(Arrays.toString(Solution3(new int[] {1, 2, 3, 4, 5}, 0)));

        System.out.println(Arrays.toString(Solution4(new int[] {1, 2, 3, 4, 5}, 10)));
    }
}
