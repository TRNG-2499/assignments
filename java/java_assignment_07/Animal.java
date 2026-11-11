// package java.java_assignment_07;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public abstract void describe();

    // shared logic lives here so subclasses don't repeat it
    public void show() {
        makeSound();
        describe();
        System.out.println();
    }
}