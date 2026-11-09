package com.revature;

public class Dog extends Animal {
    // stretch goal 1
    private final String breed = "Golden Retriever";

    public Dog() {
        super("Dog");
    }

    @Override
    public String makeSound() {
        return "Woof! Woof!";
    }

    @Override
    public String describe() {
        return "The dog wags its tail excitedly and looks up at you.";
    }

    // stretch goal 1
    // builds on describe() instead of changing it, so the original description stays the same
    @Override
    public String describeWithDetails() {
        return describe() + " It's a " + breed + ".";
    }
}
