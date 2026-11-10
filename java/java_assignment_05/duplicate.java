import java.util.Scanner;


public class duplicate {
    

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

    String quit ="N";
    String sentence = "";

    while (!(quit.equals("Y"))){

        System.out.println("Insert sentence:");
        sentence = myObj.nextLine();

        System.out.println(count(sentence));

        System.out.println("Quit? Insert Y");
        quit = myObj.nextLine();

        }
    }


    public static String count(String s){

        s = s.toLowerCase();
        String[] split = s.split(" ");

        String[] unique  = new String[split.length];
        int[] count = new int [split.length];
        
        int uniquelen = 0;

        for(int i = 0; i < split.length; i++){
            boolean dup  = false;
            String current = split[i];
            

            for(int j = 0; j < uniquelen; j++){
                if(current.equals(unique[j])){
                    dup = true;
                    count[j] += 1; //update count
                    break;
                }
            }

            if(!dup){
                unique[uniquelen] = current;
                count[uniquelen] = 1; // make original
                dup = false;
                uniquelen += 1;
            }


        }

        String res = "";

        for(int i = 0; i < uniquelen; i++){

            if(i == uniquelen - 1){
                res += String.format("%s - %d ", unique[i], count[i]);
                break;
            }

            res += String.format("%s - %d, ", unique[i], count[i]);
        }

        return res;
    }
    


}
