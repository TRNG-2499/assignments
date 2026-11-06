package java_assignments.java_assignment_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaSolution_06 {
    public static void main(String[] args) {
        calculatorStretch();
        
    }

    public static void calculator(){
        Scanner userIn = new Scanner(System.in);

        System.out.println("Enter a command!");
        String input = userIn.nextLine();
        int total = 0;
       
        while(!input.equals("exit")){
            String[] inputs = input.toLowerCase().split(" ");
    
            switch(inputs[0]){
                case("add"):
                    total+=Integer.parseInt(inputs[1]);
                    System.out.println("Added "+inputs[1]+". Running total: "+total);
                    break;
                case("subtract"):
                    total-=Integer.parseInt(inputs[1]);
                    System.out.println("Subtracted "+inputs[1]+". Running total: "+total);
                    break;
                case("total"):
                    System.out.println("Total: "+total);
                    break;
                case("reset"):
                    total=0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                default:
                    System.out.println("Error invalid command: "+inputs[0]);
                
            }
            System.out.print("Enter another command: ");
            input = userIn.nextLine();
            

        }
        System.out.println("Goodbye! Final total: "+total);

        

        userIn.close();
    }


    public static void calculatorStretch(){
        Scanner userIn = new Scanner(System.in);

        System.out.println("Enter a command!");
        String input = userIn.nextLine();
        int total = 0;

        List<String> history = new ArrayList<String>();
       
        while(!input.equals("exit")){
            String[] inputs = input.toLowerCase().split(" ");
    
            switch(inputs[0]){
                case("add"):
                    total+=Integer.parseInt(inputs[1]);
                    System.out.println("Added "+inputs[1]+". Running total: "+total);
                    history.add(input);
                    break;
                case("subtract"):
                    total-=Integer.parseInt(inputs[1]);
                    System.out.println("Subtracted "+inputs[1]+". Running total: "+total);
                    history.add(input);
                    break;
                case("total"):
                    System.out.println("Total: "+total);
                    history.add(input);
                    break;
                case("reset"):
                    total=0;
                    System.out.println("Running total has been reset to 0.");
                    history.add(input);
                    break;
                case("history"):
                    System.out.println("Command history: "+history.toString());
                    break;
                default:
                    System.out.println("Error invalid command: "+inputs[0]);
                
            }
            System.out.print("Enter another command: ");
            input = userIn.nextLine();
            

        }
        System.out.println("Goodbye! Final total: "+total);

        

        userIn.close();
    }

    public static void calculatorStretchTwo(){
        Scanner userIn = new Scanner(System.in);

        System.out.println("Enter a command!");
        String input = userIn.nextLine();
        int total = 0;

        List<String> history = new ArrayList<String>();
       
        while(!input.equals("exit")){
            String[] inputs = input.toLowerCase().split(" ");
    
            switch(inputs[0]){
                case("add"):
                    total+=Integer.parseInt(inputs[1]);
                    System.out.println("Added "+inputs[1]+". Running total: "+total);
                    history.add(input);
                    break;
                case("subtract"):
                    total-=Integer.parseInt(inputs[1]);
                    System.out.println("Subtracted "+inputs[1]+". Running total: "+total);
                    history.add(input);
                    break;
                case("total"):
                    System.out.println("Total: "+total);
                    history.add(input);
                    break;
                case("reset"):
                    total=0;
                    System.out.println("Running total has been reset to 0.");
                    history.add(input);
                    break;
                case("history"):
                    System.out.println("Command history: "+history.toString());
                    break;
                default:
                    System.out.println("Error invalid command: "+inputs[0]);
                
            }
            System.out.print("Enter another command: ");
            input = userIn.nextLine();
            

        }
        System.out.println("Goodbye! Final total: "+total);

        

        userIn.close();
    }
}
