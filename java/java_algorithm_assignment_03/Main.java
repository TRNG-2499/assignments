public class Main {

    public static String compress(String s) {
        if (s.length() == 0) {
            return s;
        }

        s = s.toLowerCase();
        String out = "";
        int cnt = 0;
        char currChar = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == currChar) {
                cnt++;
            } else {
                out = out.concat(String.format("%c%d", currChar, cnt));
                currChar = s.charAt(i);
                cnt = 1;
            }
        }

        out = out.concat(String.format("%c%d", currChar, cnt));

        return out;
    }

    public static String compressCond(String s) {
        String cs = compress(s);

        return cs.length() < s.length() ? cs : s;
    }

    public static String decompress(String s) {
        if (s.length() < 2) {
            return s;
        }

        String out = "";
        char currChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (i % 2 != 0) {
                int cnt = Integer.valueOf(String.valueOf(s.charAt(i)));
                for (int j = 0; j < cnt; j++) {
                    out = out.concat(String.valueOf(currChar));
                }
            } else {
                currChar = s.charAt(i);
            }
        }

        return out;
    }

    public static void main(String[] args) {
        String s0 = "aaabbbccd";
        String s0c = compress(s0);
        System.out.println(s0c);
        System.out.println(decompress(s0c));
        System.out.println(compress("abdc"));
        System.out.println(compress("aaaaaa"));
        System.out.println(compress("aAaA"));
        System.out.println(compress(""));
    }
}
