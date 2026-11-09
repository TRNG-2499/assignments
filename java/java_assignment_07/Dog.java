public class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Woof! Woof!";    
    }

    @Override
    public String describe() {
        return "The dog wags its tail excitedly and looks up at you."
    }
}