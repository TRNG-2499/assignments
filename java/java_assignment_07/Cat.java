package java.java_assignment_07;

public class Cat extends Animal {
    public Cat(){
        super("Cat");
    }

    @Override
    public String makeSound(){
        return "Meow";
    }

    @Override 
    public String describe(){
        return "An independent, curious hunter.";
    }
}
