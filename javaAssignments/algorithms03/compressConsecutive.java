package javaAssignments.algorithms03;

public class compressConsecutive {
    
    public static void main(String[] args) {
        // System.out.println(compressConsecutiveletters("aabbcc"));
        // System.out.println(compressConsecutiveletters("aaabccc"));
        // System.out.println(compressConsecutiveletters("aAbcd"));
        // System.out.println(compressConsecutivelettersIfShorter("aabbcc"));
        // System.out.println(compressConsecutivelettersIfShorter("aaabccc"));
        // System.out.println(compressConsecutivelettersIfShorter("aAbcd"));
        // System.out.println(decompressString("a2b2c2"));
        // System.out.println(decompressString("a3b1c3"));
        // System.out.println(decompressString("a1b1c1d1"));
        // System.out.println(decompressString("A1B1C1"));
    }

    public static String compressConsecutiveletters(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1; //any number we find will have a count of one to begin with
        for (int i = 1; i < str.length(); i++) { //loop through the string and compare each character with the previous one
            if (str.charAt(i) == str.charAt(i - 1)) { //if we find a match we increment the count
                count++;
            } else { //if we find a mismatch we append the previous character and its count to the str
                sb.append(str.charAt(i - 1)).append(count);
                count = 1; //reset the count for the new character
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count); //append the last character and its count to the str
        return sb.toString();
    }

    //Stretch goal 1, returning the compressed string only if it is shorter
    //The stretch goal just said "shorter" so I have made it only return the compressed string if it is less than but not equal to the original string's length
    public static String compressConsecutivelettersIfShorter(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1; //any number we find will have a count of one to begin with
        for (int i = 1; i < str.length(); i++) { //loop through the string and compare each character with the previous one
            if (str.charAt(i) == str.charAt(i - 1)) { //if we find a match we increment the count
                count++;
            } else { //if we find a mismatch we append the previous character and its count to the str
                sb.append(str.charAt(i - 1)).append(count);
                count = 1; //reset the count for the new character
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count); //append the last character and its count to the str
        String compressed = sb.toString();
        return compressed.length() < str.length() ? compressed : str; //just added a check at the end, we haven't actually done anything to the str reference from the start so we can just use it to compare
    }

    //stretch goal 2
    //decompressing seems very similar to compressing in an interesting way
    public static String decompressString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) { //we iterate through the string looking for numbers
            char ch = str.charAt(i);
            int count = Character.getNumericValue(str.charAt(i + 1)); //if the char is a number
            for (int j = 0; j < count; j++) {
                sb.append(ch); //we append a number of those characters based upon the count we found
            }
        }
        return sb.toString();
    }
}
