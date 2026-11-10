import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class a7_solution {
    public void zoo(){
        Animal dog = new Dog("German Shepherd");
        Animal cat = new Cat("Calico");
        Animal bird = new Bird(true);
        Scanner sc = new Scanner(System.in);
        boolean finished = false;
        System.out.println("1. Dog \n2. Cat \n3. Bird \n0. Exit");

        while (!finished){
            System.out.print("Enter your selection: ");
            try{
                int command =  sc.nextInt();
                switch (command){
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bird.makeSound();
                        bird.describe();
                        break;
                    case 0:
                        finished = true;
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid selection. Try again.");
                sc.next();
            }
        }
    }

    public void zooSurprise() {
        Animal dog = new Dog("German Shepherd");
        Animal cat = new Cat("Calico");
        Animal bird = new Bird(true);
        boolean finished = false;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Dog \n2. Cat \n3. Bird \n4. Surprise Me! \n0. Exit");
        while (!finished){
            System.out.print("Enter your selection: ");
            try{
                int command =  sc.nextInt();
                switch (command){
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bird.makeSound();
                        bird.describe();
                        break;
                    case 4:
                        int n = rand.nextInt(1,4);
                        switch (n){
                            case 1:
                                dog.makeSound();
                                dog.describe();
                                break;
                            case 2:
                                cat.makeSound();
                                cat.describe();
                                break;
                            case 3:
                                bird.makeSound();
                                bird.describe();
                                break;
                            default:
                                System.out.println("Something has gone wrong.");
                                break;
                        }
                        break;
                    case 0:
                        finished = true;
                        System.out.println("Goodbye! Thanks for visiting the zoo.");
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid selection. Try again.");
                sc.next();
            }
        }
    }
    public static void main(String[] args) {
        a7_solution s = new a7_solution();
        s.zoo();
        System.out.println("---------- Stretch Goals ----------");
        s.zooSurprise();
    }
}
