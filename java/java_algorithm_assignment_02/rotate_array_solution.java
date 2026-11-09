//import what I need

import java.util.ArrayList;
import java.util.Collections;

public static void main(String[] args){
    //Scanner for test purposes
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of elements to add to the array:");
    int count = scanner.nextInt();
    int[] array = new int[count];

    System.out.println("Enter the elements in the array:");
    for(int i = 0; i < count; i++)
        array[i] = scanner.nextInt();

    System.out.println("Enter at what index you want the array to rotate (Remember it starts at 0):");
    int k = scanner.nextInt();

    System.out.println("Rotated Array: " + Arrays.toString(ArrayRotate(k, array)));

}

//Should splice the array at k and then shift the
//rest of the values to the left in the same order
//Ensure k goes through the list again if the number
//is higher than the array length
public static int[] ArrayRotate(int k, int... array){
    List<Integer> list = new ArrayList<>();
    for (int i : array)
        list.add(i);

    Collections.rotate(list, k);

    int[] rotated = new int[array.length];
    for(int j = 0; j < array.length; j++)
        rotated[j] = list.get(j);

    return(rotated);
}