public class MissingNumberFinder {
    public static void main(String[] args) {
        int[] ints = {3,1,2,5,4,7};
        missingNumberFinder(ints);
    }
    public static void missingNumberFinder(int [] integers) {
        //selection sort
        for (int i = 0; i < integers.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minIndex]) {
                    minIndex = j;
                }
            }
            swap(integers, i, minIndex);
        }
            //binary search to find the missing number
            int left = 0;
            int right = integers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (integers[mid] == mid + 1) {
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
            System.out.println("Missing number: " + (left + 1));
    }
    // swap method to help with sorting
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
