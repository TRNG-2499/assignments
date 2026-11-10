


public static int[] rotateArray(int[] array, int k) {
    if (array == null || array.length == 0) return array; //if K is zero we return the original array

    int steps = k % array.length; // array turn steps

    for (int s = 0; s < steps; s++) {
        int last = array[array.length -1];
        

        for (int i = array.length -1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] last;
    }
    return array;


}