public class AlgorithmSolution2 {
    public static void main(String[] args) {
        int [] test = {1, 2, 3, 4, 5, 6, 7};
        test = minMemoryRotate(test, 13);
        for(int num : test)
            System.out.print(num + " ");
    }

    public static int [] rotateArr(int [] arr, int k){
        while(k >= arr.length)
            k -= arr.length;
        int split = arr.length - k;
        int [] res = new int[arr.length];
        int resIdx = 0;
        for(int i = split; i < arr.length; i++){
            res[resIdx] = arr[i];
            resIdx++;
        }
        for(int i = 0; i < split; i++){
            res[resIdx] = arr[i];
            resIdx++;
        }
        return res;
    }

    //Stretch Goal Rotate Left
    public static int [] rotateLeft(int [] arr, int k){
        while(k >= arr.length)
            k -= arr.length;
        int [] res = new int[arr.length];
        int resIdx = 0;
        for(int i = k; i < arr.length; i++){
            res[resIdx] = arr[i];
            resIdx++;
        }
        for(int i = 0; i < k; i++){
            res[resIdx] = arr[i];
            resIdx++;
        }
        return res;
    }

    //Stretch Goal Negative Step Count
    public static int [] negativeStepCount(int [] arr, int k){
        if(k < 0)
            return rotateLeft(arr, -k);
        else
            return rotateArr(arr, k);
    }

    //Minimal Extra Memory
    public static int [] minMemoryRotate(int [] arr, int k){
        while(k >= arr.length)
            k -= arr.length;
        if(k == 0)
            return arr;
        int split = arr.length - k;

        int i = 0;
        int j = split;
        while(i < arr.length -1){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
            i++;
            
            if(j >= arr.length){
                if(i > split){// occurs when #Steps > arr.length/2
                    split = arr.length - 1;
                }
                j = split;
            }
        }
        return arr;
    }
}
