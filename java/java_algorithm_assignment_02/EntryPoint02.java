import java.util.Arrays;

public class EntryPoint02 {

  public static void main(String[] args) {
    JavaAlgSol02 test = new JavaAlgSol02();

    // main
    System.out.println(
      Arrays.toString(test.rotateArrayRight(new int[] { 1, 2, 3, 4, 5 }, 2))
    );
    System.out.println(
      Arrays.toString(test.rotateArrayRight(new int[] { 1, 2, 3, 4, 5 }, 7))
    );
    System.out.println(
      Arrays.toString(test.rotateArrayRight(new int[] { 1, 2, 3 }, 0))
    );

    // stretch left
    System.out.println(
      Arrays.toString(test.rotateArrayLeft(new int[] { 1, 2, 3, 4, 5 }, 2))
    );
    System.out.println(
      Arrays.toString(test.rotateArrayLeft(new int[] { 1, 2, 3, 4, 5 }, 7))
    );

    // stretch negative step
    System.out.println(
      Arrays.toString(test.rotateArray(new int[] { 1, 2, 3, 4, 5 }, -2))
    );
    System.out.println(
      Arrays.toString(test.rotateArray(new int[] { 1, 2, 3, 4, 5 }, 2))
    );

    // stretch minimal memory
  }
}
