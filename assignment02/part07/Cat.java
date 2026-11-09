package assignment02.part07;

public class Cat extends Animal{

    protected boolean indoorcat;

    public Cat(boolean indoorcat){
        this.indoorcat = indoorcat;
    }

    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
    @Override 
    public void describe(){
        System.out.println("The cat ignores you.");
        System.out.println(indoorcat ? "This cat is an indoor cat." : "This cat is not an indoor cat.");
    }
}
