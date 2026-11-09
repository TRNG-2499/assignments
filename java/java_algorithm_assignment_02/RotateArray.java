package assignments.java.java_algorithm_assignment_02;

public class RotateArray {
    public static void main(String[] args) {
        int [] numArray1 = {1, 2, 3, 4, 5};
        int [] numArray2 = {1, 2, 3};
        int [] numArray3 = {1, 2, 3, 4};
        rotateArray(numArray1, 2);
        rotateArray(numArray2, 4);
        rotateArray(numArray3, 0);
    }

    public static void rotateArray(int[] numArray, int rotate){
        if (rotate >= numArray.length){
            rotate -= numArray.length;
        }

        if (rotate != 0){
            int[] temp = new int[rotate];
            for (int x = 0; x < temp.length; x++){
                temp[x] = numArray[numArray.length-rotate+x];
            }
            //System.out.println(temp);
            for (int x = 0; x <= rotate; x++){
                numArray[numArray.length-1-x] = numArray[numArray.length-1-rotate-x]; 
            }
            for (int x = 0; x < temp.length; x++){
                numArray[x] = temp[x]; 
            }
        }

        System.out.print("["+ numArray[0]);
        for (int x = 1; x < numArray.length; x++){
            System.out.print(", "+ numArray[x]);
        }
        System.out.println("]");
        //System.out.println(numArray);
    }
}
