import java.util.Scanner;

public class MissingNumberwithStartNumber {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the list of numbers without ',' : ");
            String input = scanner.nextLine();
            System.out.println("Please also enter the starting number: ");
            String start = scanner.nextLine();

            // Convert the string input into an actual array of integers.
            //This splits the string by spaces: "3 7 1" becomes ["3", "7", "1"]
            String [] textNumbers = input.split(" ");
            int [] numbers = new int[textNumbers.length];

            for (int i =0; i<numbers.length; i++){
                numbers[i] = Integer.parseInt(textNumbers[i]); //Converts "3" to 3
            }

            int missing = missingNumber(numbers, Integer.parseInt(start));
            System.out.println("The missing number is: " + missing);

        }

        public static int missingNumber(int [] numbers, int start){
            //calculate how many elements should be there in full
            int n = numbers.length + 1;

            //Find the ending value of the complete list
            int end = start + n -1;
            int expectedSum = n*(n+end)/2;

            int actualSum = 0;
            for(int num : numbers) {
                actualSum = actualSum + num;
            }
            return  expectedSum - actualSum;
        }
    }
