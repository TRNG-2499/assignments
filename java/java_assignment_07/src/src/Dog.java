public class Dog extends Animal {
    String breed;
    Dog(String breed) {
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    void describe() {
        System.out.println("The dog wags its tail excitedly and looks up at you. It is a " + breed + ".");
    }
}
