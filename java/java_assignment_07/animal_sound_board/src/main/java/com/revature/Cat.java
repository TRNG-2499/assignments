package com.revature;

public class Cat extends Animal {
    // stretch goal 1
    private final boolean isIndoor = true;

    public Cat() {
        super("Cat");
    }

    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }

    @Override
    public String describe() {
        return "The cat stretches lazily and blinks slowly at you.";
    }

    // stretch goal 1
    @Override
    public String describeWithDetails() {
        return describe() + (isIndoor ? " It's an indoor cat." : " It's an outdoor cat.");
    }
}
