import java.util.Arrays;

public class EntryPoint01 {

  public static void main(String[] args) {
    JavaAlgSol01 test = new JavaAlgSol01();

    // main
    System.out.println(test.findMissingNum(new int[] { 4, 2, 3 }));
    System.out.println(test.findMissingNum(new int[] { 5, 1, 4, 2 }));
    System.out.println(test.findMissingNum(new int[] { 2, 3, 1 }));
    System.out.println(test.findMissingNum(new int[] {}));

    // custom starting
    System.out.println(test.findMissingNum(new int[] { 9, 5, 8, 6 }, 5));
    System.out.println(test.findMissingNum(new int[] { 4, 0, 3, 1 }, 0));

    // two missing numbers
    System.out.println(
      Arrays.toString(test.findTwoMissingNum(new int[] { 5, 1, 3 }))
    );
    System.out.println(
      Arrays.toString(test.findTwoMissingNum(new int[] { 4, 2, 3 }))
    );
    System.out.println(
      Arrays.toString(test.findTwoMissingNum(new int[] { 2, 1, 5 }))
    );

    // duplicate and missing number
    System.out.println(
      Arrays.toString(test.findDupAndMissNum(new int[] { 4, 2, 1, 2 }))
    );
    System.out.println(
      Arrays.toString(test.findDupAndMissNum(new int[] { 3, 2, 3 }))
    );
    System.out.println(
      Arrays.toString(test.findDupAndMissNum(new int[] { 1, 1 }))
    );
  }
}
