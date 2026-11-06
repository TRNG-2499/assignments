package java_assignments.java_algorithm_assignment_02;

public class JavaAlgoSolution_02 {
    public static void main(String[] args) {
        int[] testCase = {1, 2, 3, 4, 5};
        printArr(shiftArrStretchTwo(testCase, 2));
        
    }

    public static int[] shiftArr(int[] arr, int k){
        int[] newArr = new int[arr.length];
        k=k%arr.length;
        
        if(k <= 0){
            return arr;
        }

        for(int i = 0; i<newArr.length;i++){
            newArr[(i+k)%arr.length]=arr[i];
        }

        return newArr;
    }

    public static void printArr(int[] arr){
        for(int val : arr){
            System.out.print(val+" ");
        }
    }

    public static int[] shiftArrStretch(int[] arr, int k){
        int[] newArr = new int[arr.length];
        k=k%arr.length;
        
        if(k <= 0){
            return arr;
        }
        
        for(int i = 0; i<newArr.length;i++){
            newArr[i]=arr[(i+k)%arr.length];
        }

        return newArr;
    }

    public static int[] shiftArrStretchTwo(int[] arr, int k){
        int[] newArr = new int[arr.length];
        k=k%arr.length;
        
        if(k < 0){
            k=Math.abs(k);
            for(int i = 0; i<newArr.length;i++){
                newArr[i]=arr[(i+k)%arr.length];
            }
            return newArr;
        }
        
        if(k > 0){
            for(int i = 0; i<newArr.length;i++){
                newArr[(i+k)%arr.length]=arr[i];
            }
            return newArr;
        }

       return arr;

        
    }
}
