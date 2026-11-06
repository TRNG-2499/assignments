import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Integer[] values = Arrays.stream(args).map(Integer::parseInt).toArray(size -> new Integer[size]);

    System.out.println(findMissing(values));
  }

  public static int findMissing(Integer[] values) {
    Arrays.sort(values);
    for (int i = 0; i < values.length - 1; i++) {
      if (values[i] + 1 != values[i + 1]) {
        return values[i] + 1;
      }
    }
    return -1;
  }
}
