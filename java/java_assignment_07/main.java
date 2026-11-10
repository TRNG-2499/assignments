import java.util.Scanner;


class Animal {
    public void makeSound() {
        System.out.println("An animals sound");
    }
    public void describe() {
        System.out.println("An animals description");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("The dog goes 'woof'");
    }

    public void describe() {
        System.out.println("A dog is a domesticated mammal, descendent from wolves");
    }
}
class Cat extends Animal {
    public void makeSound() {
        System.out.println("The cat goes 'Meow'");
    }

    public void describe() {
        System.out.println("A cat is a small carnivorous mammal, belonging to the family Felidae");
    }
}
class Bird extends Animal {
    public void makeSound() {
        System.out.println("The bird goes 'chirp chirp!'");
    }

    public void describe() {
        System.out.println("A bird is a warm-blooded, egg-laying vertebrate animal distinguished by its feathers, beak (without teeth), two wings, and two legs");
    }
}




class main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();
        dog.makeSound();
        dog.describe();
        cat.makeSound();
        cat.describe();
        bird.makeSound();
        bird.describe();


    }
}