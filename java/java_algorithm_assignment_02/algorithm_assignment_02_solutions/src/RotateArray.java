import java.util.Arrays;

public class RotateArray {
    static void main() {
        RotateArray inst = new RotateArray();
        int k = 0;

        /*
        Core test
         */
        System.out.println("Core test:");
        int[] a1 = {1,2,3,4,5};
        k = 7;
        System.out.println(Arrays.toString(inst.rotate(a1, k)));
//        int[] a2 = {1,2,3};
//        k = 4;
//        System.out.println(Arrays.toString(inst.rotate(a2, k)));
//        int[] a3 = {1,2,3,4};
//        k = 0;
//        System.out.println(Arrays.toString(inst.rotate(a3, k)));
//        int[] a4 = {};
//        k = 4;
//        System.out.println(Arrays.toString(inst.rotate(a4, k)));

        /*
        Stretch test
         */
        System.out.println("Stretch test:");
        int[] a5 = {1,2,3,4,5};
        k = 2;
        System.out.println(Arrays.toString(inst.rotateLeft(a5, k)));
        k = -2;
        System.out.println(Arrays.toString(inst.negativeStepRotate(a5, k)));
        k = 7;
        System.out.println(Arrays.toString(inst.negativeStepRotate(a5, k)));
    }

    public int[] rotate(int[] iArr, int rotateSteps) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be empty.");
            return new int[] {};
        } else if (rotateSteps == 0) {
            return iArr;
        }

        int arrLen = iArr.length;
        int[] newArr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            newArr[(i + rotateSteps) % arrLen] = iArr[i];
        }
        return newArr;
    }

    public int[] rotateLeft(int[] iArr, int rotateSteps) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be empty.");
            return new int[] {};
        } else if (rotateSteps == 0) {
            return iArr;
        }

        int arrLen = iArr.length;
        int[] newArr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            int modIdx = (i - rotateSteps) % arrLen;
            if (modIdx < 0) {
                modIdx = arrLen + modIdx;
            }
            newArr[modIdx] = iArr[i];
        }
        return newArr;
    }

    public int[] negativeStepRotate(int[] iArr, int rotateSteps) {
        if (rotateSteps < 0) {
            return rotateLeft(iArr, -rotateSteps);
        } else {
            return rotate(iArr, rotateSteps);
        }
    }

    public int[] rotateLowMem(int[] iArr, int rotateSteps) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be empty.");
            return new int[] {};
        } else if (rotateSteps == 0) {
            return iArr;
        }

        int arrLen = iArr.length;
        int idx = 0;
        int curCopy = iArr[idx];
        for (int i = 0; i < arrLen; i++) {
            int placement = (idx + rotateSteps) % arrLen;
            int placementCopy = iArr[placement];
            iArr[placement] = curCopy;
            curCopy = placementCopy;
            idx += rotateSteps;
        }
        return iArr;
    }
}
