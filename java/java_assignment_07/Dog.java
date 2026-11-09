package java_assignment_07;

public class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Bark!";
    }

    @Override
    public String describe() {
        return "Loyal animal with a strong sense of smell.";
    }
}
