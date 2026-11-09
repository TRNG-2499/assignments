package java_assignment_07;

public class Bird extends Animal {
    @Override
    public String makeSound() {
        return "Tweet!";
    }

    @Override
    public String describe() {
        return "Animal with two wings that can fly.";
    }
}
