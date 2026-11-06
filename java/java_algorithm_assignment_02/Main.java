import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Integer[] values_and_rotate_count = Arrays.stream(args).map(Integer::parseInt).toArray(size -> new Integer[size]);
    Integer[] values = Arrays.copyOfRange(values_and_rotate_count, 1, values_and_rotate_count.length);
    Integer[] right_values = rotateRight(values_and_rotate_count[0], values);
    Integer[] left_values = rotateLeft(values_and_rotate_count[0], values);
    System.out.print("Right: ");
    printArray(right_values);
    System.out.print("Left: ");
    printArray(left_values);
  }

  public static void printArray(Integer[] values) {
    System.out.print("[");
    for (int i = 0; i < values.length - 1; i++) {
      System.out.print(values[i] + ", ");
    }
    System.out.println(values[values.length - 1] + "]");
  }

  public static Integer[] rotateRight(int rotate_count, Integer[] values) {
    values = values.clone();
    int new_start;
    if (rotate_count >= 0) {
      new_start = rotate_count % values.length;
    } else {
      new_start = values.length - (-rotate_count % values.length);
    }
    Integer[] first_slice = Arrays.copyOfRange(values, values.length - new_start, values.length);
    Integer[] second_slice = Arrays.copyOfRange(values, 0, values.length - new_start);
    for (int i = 0; i < first_slice.length; i++) {
      values[i] = first_slice[i];
    }
    for (int i = 0; i < second_slice.length; i++) {
      values[i + first_slice.length] = second_slice[i];
    }
    return values;
  }

  public static Integer[] rotateLeft(int rotate_count, Integer[] values) {
    values = values.clone();
    int new_start;
    if (rotate_count >= 0) {
      new_start = rotate_count % values.length;
    } else {
      new_start = values.length - (-rotate_count % values.length) - 1;
    }
    Integer[] first_slice = Arrays.copyOfRange(values, new_start, values.length);
    Integer[] second_slice = Arrays.copyOfRange(values, 0, new_start);
    for (int i = 0; i < first_slice.length; i++) {
      values[i] = first_slice[i];
    }
    for (int i = 0; i < second_slice.length; i++) {
      values[i + first_slice.length] = second_slice[i];
    }
    return values;
  }
}
