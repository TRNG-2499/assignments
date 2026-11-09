package javaAssignments.java_assignment_07;
import java.util.Scanner;

public class dog extends animal{
    
    public dog(String sound, String description) {
        //the super  here lets us just pass the constructor up to the animal class
        super(sound, description);
    }

    @Override
    public void makeSound() {
        System.out.println(sound);
    }

    @Override
    public void describe() {
        System.out.println(description);
    }


    //stretch goal
    public void play() { //the dog takes the menu and runs away! you have to hit W to catch the dg
        System.out.println("The dog has run away with the menu! \nChase the dog to get it back by inputing W!");
        int running = 0;
        while (running < 3){
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.equalsIgnoreCase("W")) {
                System.out.println("You chased the dog and got the menu back!");
                running = 3; //exit the loop
            } else {
                System.out.println("The dog keeps running! Try again.");
                running++; //prevents people from getting locked out
            }
        }
    }
}
