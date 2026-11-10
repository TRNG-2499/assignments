package java.java_assignment_07.java_assignment_07;

public class Bird extends Animal {
    @Override 
    public String makeSound() {
        return "tweet";
    }
    @Override 
    public String describe() {
        return "This is a bird, and it flies up high in the sky!";
    }
}