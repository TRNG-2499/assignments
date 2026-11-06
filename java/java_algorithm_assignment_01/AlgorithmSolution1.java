import java.util.HashSet;
public class AlgorithmSolution1 {
    public static void main(String[] args) {
        System.out.println(findMissingNum(13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1));
    }
    public static int findMissingNum(int... input){
        HashSet <Integer> distinctInt = new HashSet<>();
        for(int i = 1; i < input.length + 1; i++){
            distinctInt.add(i);
        }
        for(int num : input)
            distinctInt.remove(num);

        Object [] res = distinctInt.toArray();
        if(res.length == 1)
            return (Integer)res[0];
        else
            return -1;
    }
}
