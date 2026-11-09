package javaAssignments.java_assignment_07;

import java.util.Scanner;

public class cat extends animal{

    public cat(String sound, String description) {
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
    public void lounge(){ //a cat walks onto the menu and starts sleeping! you've got to do something about that
        System.out.println("Oh no! The cat is lounging on the menu!");
        System.out.println("You need to gently move the cat to get the menu back.");
        System.out.println("  _._     _,-'\"\"`-._");
        System.out.println(" (,-.`._,'(       |\\`-/|");
        System.out.println("     `-.-' \\ )-`( , o o)");
        System.out.println("           `-    \\`_`\"'-)");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter G to gently move the cat: ");
        String input = sc.next();
        if (input.equalsIgnoreCase("G")) { //G for gentle!
            System.out.println("You gently moved the cat!");
        } else {
            System.out.println("The cat is startled and jumps away! It is angry at you now.");
        }
    }
}
