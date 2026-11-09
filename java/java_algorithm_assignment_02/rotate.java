public class rotate{

    public static int[] rotatearray(int[] arr, int k) {
        int[] newArr = new int[arr.length];
        int temp = 0;
        k = k% arr.length;
        for(int i = 0; i <arr.length;i++) {
            int newIndex = (i+k) % arr.length;
            newArr[newIndex] = arr[i];
        }
        for(int i =0; i<arr.length;i++) {
            System.out.println(newArr[i] + " ");
        }
        return newArr;
    }
    public static void main(String[] args) {
        System.out.println(rotatearray(new int [] {1, 2, 3, 4, 5},2));
    }
}