// package java.java_assignment_07;

public class Cat extends Animal {
    private boolean isIndoor;

    public Cat() {
        super("cat");
        this.isIndoor = true;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        String home = isIndoor ? "an indoor" : "an outdoor";
        System.out.println("The " + name + " is " + home + " cat. It stretches lazily and stares at you.");
    }
}