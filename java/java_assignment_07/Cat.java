package java_assignment_07;

public class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Meow!";
    }

    @Override
    public String describe() {
        return "Small, keen-eyed animal with retractable claws.";
    }
}
