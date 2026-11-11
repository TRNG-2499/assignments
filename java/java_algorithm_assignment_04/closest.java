public class closest{

public static int close(int[] arr, int target) {
    int dif = Integer.MAX_VALUE;
    int c = -1;
    for(int i = 0; i <arr.length;i++) {
        int current_dif = Math.abs(arr[i] - target);
        if(current_dif < dif || (current_dif == dif && arr[i] < c)) {
            dif = Math.abs(arr[i] - target);
            c = arr[i];
        }
    }
    System.out.println(c);
    return c;
}
public static void main(String[] args) {
    close(new int [] {4, 9, 1, 15, 8},10);
    close(new int [] {4, 9, 1, 15, 8},2);
    close(new int [] {5,15},10);
    close(new int [] {15,5},10);
    close(new int [] {},10);
}
}