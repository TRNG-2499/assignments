package java_assignment_07.java_assignment_07;

public class Dog extends Animal {
    @Override 
    public String makeSound() {
        return "woof wooof!";
    }

    @Override 
    public String describe() {
        return "This is a dog, and it barks, and barks!";
    }
}