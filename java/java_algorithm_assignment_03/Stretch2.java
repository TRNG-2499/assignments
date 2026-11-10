public class Stretch2 {

    //Stretch 2: Given a compressed string, decompress it
    public static String decompressString(String input){

        String decompressedString = "";
        int counter = 0;

        for(int i = 0; i < input.length() - 1; i+=2){
            counter = Integer.parseInt(String.valueOf(input.charAt(i+1)));

            for(int j = 0; j < counter; j++){
                decompressedString = decompressedString + input.charAt(i);
            }
        }

        //Catches the case where the string is empty
        if(input.isEmpty()){
            return decompressedString;
        }

        return decompressedString;
    }

    public static void main(String[] args){
        //Test 1: Regular Case
        System.out.println("input: a3b3c2d1");
        System.out.println(decompressString("a3b3c2d1")); //Expecting aaabbbccd

        //Test 2: No Repeats
        System.out.println("input: a1b1c1d1");
        System.out.println(decompressString("a1b1c1d1")); //Expecting abcd

        //Test 3: Entire string is one run
        System.out.println("input: a6");
        System.out.println(decompressString("a6")); //expecting aaaaaa

        //Test 4: Empty String
        System.out.println("input: ");
        System.out.println(decompressString("")); //expecting ""
    }

}
