package java.java_assignment_07;

public class Bird extends Animal{
    public Bird(){
        super("Bird");
    }

    @Override
    public String makeSound(){
        return "Tweet";
    }

    @Override 
    public String describe(){
        return "I believe I can fly, I believe I can touch the sky";
    }
}
