import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public static void main(String[] args){
    //Scanner is for testing purposes
    Scanner scanner = new Scanner(System.in);

    System.out.println("Provide the amount of numbers you would like in the array:");
    int temp = scanner.nextInt();
    int[] numbers = new int[temp];

    System.out.println("Provide the numbers you will include in the array");
    for (int i = 0; i < temp; i++)
        numbers[i] = scanner.nextInt();

    NumberFinder(numbers);

    scanner.close();

}

//First sort the array in ascending order
//For the missing number, it should get the number that is above it
//and perform (n) - 1. Then insert that into the array

public static void NumberFinder(int... numbers){
    //Creates a new list object that can dynamically be added onto
    List<Integer> list = new ArrayList<>();
    for(int num : numbers){
        list.add(num);
    }

    //Standard Selection Sort work
    for(int i = 0; i < list.size() - 1; i++){
        int min = i;

        for(int j = i + 1; j < list.size(); j++){
            if(list.get(j) < list.get(min))
                min = j;
        }
        int temp = list.get(min);
        list.set(min, list.get(i));
        list.set(i, temp);

        //For adding more to the list in the case of missing variables
        //Works for more than just 1 variable
        if(i > 0){
            int current = list.get(i);
            int previous = list.get(i - 1);
            if(previous != current - 1 && current > previous){
                list.add(i, current - 1);
                i--;
            }
        }
    }
    System.out.println("Sorted list: " + list);
}