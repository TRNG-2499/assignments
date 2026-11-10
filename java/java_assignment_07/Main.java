package assignments.java.java_assignment_07;
import java.util.Scanner;


public class Main {

    public static void main(String args[]){


        Scanner myObj = new Scanner(System.in);
        String input = "";
        String options = "1. Dog \n2. Cat \n3. Bird \n0. Exit \nEnter your selection";

        while(true){

            System.out.println(options);
            input = myObj.nextLine();

            if(input.equals("0")){
                System.out.println("Goodbye, thanks for visiting the zoo");
                break;
            }
            else if(input.equals("1")){
                Animal Dog1 = new Dog();
                Dog1.makeSound();
                Dog1.describe();
            }
            else if(input.equals("2")){
                Animal Cat1= new Cat();
                Cat1.makeSound();
                Cat1.describe();
            }
            else if(input.equals("3")){
                Animal Bird1 = new Bird();
                Bird1.makeSound();
                Bird1.describe();
            }
            else{
                System.out.println("Invalid number.");
            }
        }

        myObj.close();

    }
    
}
