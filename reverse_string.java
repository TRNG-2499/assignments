class Main {
    String reverse_string(String str) {
        String tmp = "himom"; //len 5
        char c;

        StringBuilder sb = new StringBuilder(tmp);
        for(int i = 0; i < (int)(tmp.length() / 2); i++) {
            c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(tmp.length() - i));
            sb.setCharAt(tmp.length() - i, c);
        }

        return tmp;
    }

    public static void main(String[] args) {
        String tmp = "sb";

        Main obj = new Main();
        System.out.println(obj.reverse_string(tmp));
    }
}