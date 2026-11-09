public class miss {

    public static int missing(int[] array) {
        int numb = 0;
        int total = 0;
        for (int j = 1; j <= array.length+1;j++) {
            numb+=j;
        }
        for(int i = 0; i<array.length;i++) {
            total += array[i];
        }

        return numb - total;
    }
    public static void main(String[] args) {
        System.out.println(missing(new int[] {3, 7, 1, 2, 8, 4, 5}));
        System.out.print(missing(new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
    }
}