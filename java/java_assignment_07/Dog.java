package java.java_assignment_07;

public class Dog extends Animal{
    public Dog(){
        super("Dog");
    }

    @Override 
    public String makeSound(){
        return "Woof";
    }

    @Override 
    public String describe(){
        return "Who let the dogs out?";
    }
}
