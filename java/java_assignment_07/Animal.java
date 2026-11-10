public abstract class Animal {

    public abstract void makeSound();
    public abstract void describe();


    public void display() {
        makeSound();
        describe();
    }
}
