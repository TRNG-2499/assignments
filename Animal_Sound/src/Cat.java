public class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println("Cat looks at you so innocently and then stretches and purrs softly.");
    }
}
