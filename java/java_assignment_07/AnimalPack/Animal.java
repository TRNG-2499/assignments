package AnimalPack;

import java.util.Scanner;

public abstract class Animal {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dog \n2. Cat \n3. Bird \n0. Exit");
            System.out.print("Enter your selection: ");

            int selectedNum = scan.nextInt();

            if (selectedNum == 0){
                System.out.println("Thanks for checking these animals out, Bye!");
                break;
            } else if (selectedNum == 1) {
                Animal d = new Dog();
                System.out.println(d);
            }else if (selectedNum == 2) {
                Animal c = new Cat();
                System.out.println(c);
            }else if (selectedNum == 3) {
                Animal b = new Bird();
                System.out.println(b);
            }else {
                System.out.println("Invalid input");
            }
        }
    }
    protected static String makeSound(){
        return "...";
    }
    protected static String describe(){
        return "any of a kingdom (Animalia) of living things including " +
                "many-celled organisms and often many of the single-celled ones";
    }
}
