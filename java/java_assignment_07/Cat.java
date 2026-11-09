package assignments.java.java_assignment_07;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println("The cat licks its paws and runs away.");
    }
}