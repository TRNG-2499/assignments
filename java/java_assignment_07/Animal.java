package java_assignment_07;

public abstract class Animal {
    public abstract String makeSound();

    public abstract String describe();

    public final void displayInformation() {
        System.out.println(makeSound());
        System.out.println(describe());
    }
}
