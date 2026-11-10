package assignments.java.java_assignment_07;

public abstract class Animal {
    public abstract void makeSound();
    public abstract void describe();

    public void perform() {
        makeSound();
        describe();
        System.out.println();
    }

   
    
}
