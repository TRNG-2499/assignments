import java.util.Scanner;

public class ReverseString {



    public static void main(String args[]){

    System.out.print("Insert string");
    Scanner myObj = new Scanner(System.in);

    String input = myObj.nextLine(); //Next line reads newline characters, youhave to clear with myObj.nextLine();

    //Scan close

    System.out.println(reverse(input));

    
    }

    public static String reverse(String s){

        String s2 = "";

        for(int i = s.length() - 1; i > -1; i--){
            s2 += s.charAt(i);

        }

        return s2;

    }


}
