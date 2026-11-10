import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Integer[] check_and_array = Arrays.stream(args).map(Integer::parseInt).toArray(size -> new Integer[size]);
    System.out.println(closestInArray(check_and_array[0], Arrays.copyOfRange(check_and_array, 1, args.length - 1)));
  }

  public static int closestInArray(int check, Integer[] array) {
    int absdiff = Integer.MAX_VALUE;
    int index = -1;

    for (int i = 0; i < array.length; i++) {
      int current_absdiff = Math.abs(check - array[i]);
      if (current_absdiff < absdiff) {
        absdiff = current_absdiff;
        index = i;
      } else if (current_absdiff == absdiff && array[i] < array[index]) {
        index = i;
      }
    }

    return array[index];
  }
}
