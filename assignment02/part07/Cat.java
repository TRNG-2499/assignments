package assignment02.part07;

public class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
    @Override 
    public void describe(){
        System.out.println("The cat ignores you.");
    }
}
