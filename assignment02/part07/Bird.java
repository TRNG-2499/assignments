package assignment02.part07;

public class Bird extends Animal{

    boolean canFly;

    public Bird(boolean canFly){
        this.canFly = canFly;
    }

    @Override
    public void makeSound(){
        System.out.println("Chirp Chirp");
    }
    @Override
    public void describe(){
        System.out.println("The bird tilts its head and hops along its perch.");
        System.out.println(canFly ? "This bird can fly.":"This bird cannot fly.");
    }
}
