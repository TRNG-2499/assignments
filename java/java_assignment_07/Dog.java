package assignments.java.java_assignment_07;

public class Dog extends Animal {
    @Override 
    public void makeSound() {
        System.out.println("Woof Woof");
    }

    @Override 
    public void describe() {
        System.out.println("A small black dog, full of energy and always looking for treats");
    }
    
}
