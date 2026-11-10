import java.util.Scanner;

public static void main(String[] args){
    //Scanner is used for testing purposes
    Scanner scan = new Scanner(System.in);

    System.out.println("Please provide the string you would like to test:");
    String input = scan.nextLine();

    System.out.println("Input:" + input.toString());
    Compress(input);

    scan.close();
}

public static void Compress(String characters){
    char firstCharacter = characters.charAt(0);
    StringBuilder buffer = new StringBuilder();
    int counter = 1;

    if (characters.isEmpty()) {
        System.out.println("Output: Empty string.");
        return;
    }

    for(int i = 1; i < characters.length(); i++){
        char previous = characters.charAt(i-1);
        char current = characters.charAt(i);

        //Comparing the values case-insensitively to get a count
        if(Character.toLowerCase(previous) == Character.toLowerCase(current))
            counter++;
        else{
            //Appends the first instance of the character while keeping its casing
            buffer.append(firstCharacter).append(counter);
            firstCharacter = current;
            counter = 1;
        }
    }
    buffer.append(firstCharacter).append(counter);
    System.out.println("Output: " + buffer);
}