import java.util.Scanner;

public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the amount of elements in your array");
    int elements = scan.nextInt();
    int[] array = new int[elements];

    System.out.println("Create the array of numbers");
    for(int i = 0; i < elements; i++)
        array[i] = scan.nextInt();

    System.out.println("Enter your target number:");
    int target = scan.nextInt();

    int solution = ClosestValue(target, array);

    if(solution == -1)
        System.out.println("Returned -1. No array size specified. Shutting down");
    else
        System.out.println("The number closest to your target is " + array[solution]);

    scan.close();
}

public static int ClosestValue(int target, int[] array){
    //Standard Linear Search
    int[] distance = new int[array.length];
    if(array.length == 0)
        return -1;
    for(int i = 0; i < array.length; i++){
        if(target != array[i]){
            distance[i] = array[i] - target;
            if(distance[i] < 0)
                distance[i] = distance[i] + (-2 * distance[i]);
        }
        else if(target == array[i])
            return array[i];
        }
    //Finding the number closest to the target
    int get_index = 0;
    int smallest = distance[0];
    for(int k = 0; k < distance.length; k++)
        if(smallest > distance[k]){
            smallest = distance[k];
            get_index = k;
        }

    return get_index;
}