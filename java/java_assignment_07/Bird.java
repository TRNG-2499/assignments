// package java.java_assignment_07;

public class Bird extends Animal {
    private boolean canFly;

    public Bird() {
        super("bird");
        this.canFly = true;
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void describe() {
        String flyText = canFly ? "It can fly" : "It cannot fly";
        System.out.println("The " + name + " tilts its head and hops along its perch. " + flyText);
    }
}