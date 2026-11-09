public abstract class Animal {

    public abstract String makeSound();

    public abstract String describe();

    // Every animal is displayed in the same order.
    public void display() {
        System.out.println(makeSound());
        System.out.println(describe());
    }
}