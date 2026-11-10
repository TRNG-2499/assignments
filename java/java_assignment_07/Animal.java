package java.java_assignment_07;
// import java.util.Scanner;

abstract class Animal {
    private final String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract String makeSound();
    public abstract String describe();

    public final void present(){
        System.out.println();
        System.out.println("--- "+ name + "---");
        System.out.println("Sound: "+ makeSound());
        System.out.println("About: "+ describe());
        System.out.println();
    }
}

