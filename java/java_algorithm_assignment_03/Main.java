public class Main {

    public static String compressString(String input){

        String compressedString = "";
        int counter = 1;

        input = input.toLowerCase();

        for(int i = 0; i < input.length() - 1; i++){
            if(input.charAt(i) == input.charAt(i+1)){
                counter++;
            } else {
                compressedString = compressedString + input.charAt(i) + counter;
                counter = 1;
            }
        }

        //Catches the case where the string is empty
        if(input.isEmpty()){
            return compressedString;
        }

        //for the final index
        compressedString = compressedString + input.charAt(input.length()-1) + counter;

        return compressedString;
    }

    public static void main(String[] args){
        //Test 1: Regular Case
        System.out.println("input: aaabbbccd");
        System.out.println(compressString("aaabbbccd")); //Expecting a3b3c2d1

        //Test 2: No Repeats
        System.out.println("input: abcd");
        System.out.println(compressString("abcd")); //Expecting a1b1c1d1

        //Test 3: Entire string is one run
        System.out.println("input: aaaaaa");
        System.out.println(compressString("aaaaaa")); //expecting a6

        //Test 4: Case Insensitive
        System.out.println("input: aAaA");
        System.out.println(compressString("aAaA")); //expecting a4

        //Test 4: Empty String
        System.out.println("input: ");
        System.out.println(compressString("")); //expecting a4
    }

}
