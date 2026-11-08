public class algo1_solution {
    public void solution(int[] numArray){
        boolean isFound;
        for(int i=1; i<=numArray.length; i++){
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
    public static void main(String[] args) {
        algo1_solution a1  = new algo1_solution();
        a1.solution(new int[]{1,2,3,4,5,6,7,9,10}); // expect 8
        a1.solution(new int[]{3,4,6,2,5,7}); // expect 1
        a1.solution(new int[]{10,8,6,4,2,1,3,5,9}); // expect 7
        a1.solution(new int[]{7,2,8,9,1,5,4,10,3}); // expect 6
    }
}
