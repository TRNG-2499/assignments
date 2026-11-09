package assignments.java.InClass;

public class ReverseString {
    public static void main(String[] args) {
        reverseTheString("password");
        reverseTheString("Password1");
        reverseTheString("P@ssw0rd");
        reverseTheString("");
    }

    public static void reverseTheString(String s){
        String reverse = "";
        char temp;
        //System.out.println(s.charAt(s.length()-2));
        for (int x = s.length()-1; x >= 0; x--){
            temp = s.charAt(x);
            reverse += temp;
        }

        System.out.println(reverse);
    }
}
