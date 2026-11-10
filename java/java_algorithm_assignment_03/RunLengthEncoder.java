public class RunLengthEncoder {
    public static void main(String... args) {
        String test1 = "AabBBbbCaAcc";
        String test2 = lazyCompress(test1);
        String test3 = smartCompress(test1);
        System.out.println(lazyCompress(test1));
        System.out.println(smartCompress(test1));
        System.out.println(runLengthDecode(test2));
        System.out.println(runLengthDecode(test3));

    }

    public static String lazyCompress(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < cArray.length) {
            char c = cArray[i];
            int run = runCounter(c, i, cArray);
            sb.append(c);
            sb.append(run);
            i += run;
        }

        return sb.toString();
    }

    public static String smartCompress(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < cArray.length) {
            char c = cArray[i];
            int run = runCounter(c, i, cArray);

            if (run <= 2) {
                sb.append(cArray, i, run);
            } else {
                String tmp = "" + c + run;
                sb.append(tmp);
            }
            i += run;
        }

        return sb.toString();
    }

    public static int fetchNumber(int i, char[] cArray) {
        if ((i + 1 < cArray.length && !Character.isDigit(cArray[i + 1])) || i+1 >= cArray.length) {
            return Character.getNumericValue(cArray[i]);
        } else {
            return ((10 * Character.getNumericValue(cArray[i])) + fetchNumber(i+1, cArray));
            }
    }

    public static String runLengthDecode(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < cArray.length) {
            if ((i + 1 < cArray.length && !Character.isDigit(cArray[i + 1])) || i+1 >= cArray.length) {
                sb.append(cArray[i]);
                i++;
            } else if (i + 1 < cArray.length) {
                int run = fetchNumber(i + 1, cArray);
                sb.append(String.valueOf(cArray[i]).repeat(run));
                i += String.valueOf(run).length() + 1;
            }
        }


        return sb.toString();
    }

    public static int runCounter(char c, int index, char[] cArray) {
        int count = 0;
        do { 
            if (String.valueOf(cArray[index]).equalsIgnoreCase(String.valueOf(c))) {
                count++;
                index++;
            }
        } while (index < cArray.length && String.valueOf(cArray[index]).equalsIgnoreCase(String.valueOf(c)));

        return count;
    }


}