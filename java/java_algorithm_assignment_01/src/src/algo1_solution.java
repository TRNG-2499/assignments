import java.util.Arrays;

public class algo1_solution {
    public void solution(int[] numArray){
        boolean isFound;
        for(int i=1; i<=numArray.length+1; i++){
            isFound = false;
            for(int n: numArray){
                if(n == i){ // basic idea is to iterate through list and find it while incrementing
                    isFound = true;
                }
            }
            if(!isFound){ // if it ever can not find the value in the entire array, then prints it out and returns it
                System.out.println(i);
                return;
            }
        }
    }
    public void customStart(int[] numArray, int start){
        boolean isFound;
        for(int i=start; i<=numArray.length+1+start; i++){
            isFound = false;
            for(int n: numArray){
                if(n == i){ // basic idea is to iterate through list and find it while incrementing
                    isFound = true;
                }
            }
            if(!isFound){ // if it ever can not find the value in the entire array, then prints it out and returns it
                System.out.println(i);
                return;
            }
        }
    }
    public void twoMissing(int[] numArray){
        boolean isFound;
        boolean isFirst = true;
        int[] result = new int[0];
        int firstMissing = 0;
        for(int i=1; i<=numArray.length + 2; i++){
            isFound = false;
            for(int n: numArray){
                if(n == i){ // basic idea is to iterate through list and find it while incrementing
                    isFound = true;
                }
            }
            if(!isFound){ // if it ever can not find the value in the entire array, then prints it out and returns it
                if(isFirst){
                    firstMissing = i;
                    isFirst = false;
                }else{
                    result = new int[]{firstMissing, i};
                    System.out.println(Arrays.toString(result));
                    return;
                }
            }
        }
    }
    public void dupeInclude(int[] numArray){
        boolean isFound;
        boolean dupeFound = false;
        int dupeNum = 0;
        int missingNum = 0;
        int ticker = 0;
        int[] dupeArrayCheck = new int[numArray.length];
        for(int i=1; i<=numArray.length; i++){
            isFound = false;
            for(int n: numArray){
                if(n == i){ // basic idea is to iterate through list and find it while incrementing
                    isFound = true;
                }
            }
            if(!dupeFound){
                for(int j = 0; j < ticker; j++) {
                    if (dupeArrayCheck[j] == numArray[ticker]) {
                        dupeFound = true;
                        dupeNum = numArray[ticker];
                    }
                }
                if(!dupeFound){
                    dupeArrayCheck[ticker] = numArray[ticker];
                }
            }
            if(!isFound){ // if it ever can not find the value in the entire array, then prints it out and returns it
                missingNum = i;
            }
            if(dupeFound && missingNum!= 0){
                System.out.println("Duplicate: " + dupeNum + ", Missing: " + missingNum);
                return;
            }
            ticker++;
        }
    }
    public static void main(String[] args) {
        algo1_solution a1  = new algo1_solution();
        a1.solution(new int[]{1,2,3,4,5,6,7,9,10}); // expect 8
        a1.solution(new int[]{3,4,6,2,5,7}); // expect 1
        a1.solution(new int[]{10,8,6,4,2,1,3,5,9}); // expect 7
        a1.solution(new int[]{7,2,8,9,1,5,4,10,3}); // expect 6
        System.out.println("--------- Stretch Goals ----------");
        a1.twoMissing(new int[]{1,2,3,5,6,9,10}); // expect 4 and 7
        a1.twoMissing(new int[]{3,1,5}); // expect 2 and 4
        a1.twoMissing(new int[]{3}); // expect 1 and 2
        a1.customStart(new int[]{4,5,9,6,8},4); // expect 7
        a1.customStart(new int[]{10,5,9,7,6,8},4); // expect 4
        a1.dupeInclude(new int[]{1,2,3,5,5,6,7}); // expect dupe 5, missing 4
        a1.dupeInclude(new int[]{1,1,2,3,4,5,6,7,9}); // expect dupe 1, missing 8
        a1.dupeInclude(new int[]{2,3,4,5,6,7,8,9,9}); // expect dupe 9, missing 1
    }
}
