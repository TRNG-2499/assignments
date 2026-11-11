// package java.java_assignment_07;

public class Dog extends Animal {
    private String breed;

    public Dog() {
        super("dog");
        this.breed = "Golden Retriever";
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void describe() {
        System.out.println("The " + name + " is a " + breed + ". It wags its tail excitedly and looks up at you.");
    }
}