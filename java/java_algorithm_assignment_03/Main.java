public class Main {
  public static void main(String[] args) {
    if (args.length == 1) {
      System.out.println(compressConsecutive(args[0]));
    }
  }

  public static String compressConsecutive(String input) {
    input = input.toLowerCase();

    char current = ' ';
    int count = 0;

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c != current) {
        if (current != ' ') {
          builder.append(current);
          builder.append(count);
        }

        current = c;
        count = 1;
      } else {
        count++;
      }
    }

    builder.append(current);
    builder.append(count);

    return builder.toString();
  }
}
