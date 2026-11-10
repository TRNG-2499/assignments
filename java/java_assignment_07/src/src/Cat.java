public class Cat extends Animal {
    String breed;

    Cat(String breed) {
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    void describe() {
        System.out.println("The cat lazily lies down onto the ground. It is a " + breed + ".");
    }
}
