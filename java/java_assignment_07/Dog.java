package assignments.java.java_assignment_07;

public class Dog extends Animal {
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");    
    }

    @Override
    public void describe() {
        System.out.println("The dog wags its tail excitedly and looks up at you.");
        System.out.println("This dog is a " + breed + ".");
    }
}