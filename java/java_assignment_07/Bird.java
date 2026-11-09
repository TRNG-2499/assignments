package assignments.java.java_assignment_07;

public class Bird extends Animal {
    private boolean canFly;

    public Bird(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void describe() {
        System.out.println("The bird tilts its head and hops along its perch.");
        if (canFly) {
            System.out.println("This bird can fly.");
        } else {
            System.out.println("This bird can't fly.");
        }
    }
}