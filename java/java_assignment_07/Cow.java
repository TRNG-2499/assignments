package java.java_assignment_07;

public class Cow extends Animal{
    public Cow(){
        super("Cow");
    }
    @Override 
    public String makeSound(){
        return "Moo";
    }

    @Override 
    public String describe(){
        return "A gentle grazer that produces milk people drink..";
    }
}
