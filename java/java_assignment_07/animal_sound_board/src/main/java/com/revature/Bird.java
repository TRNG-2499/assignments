package com.revature;

public class Bird extends Animal {
    // stretch goal 1
    private final boolean canFly = true;

    public Bird() {
        super("Bird");
    }

    @Override
    public String makeSound() {
        return "Tweet! Tweet!";
    }

    @Override
    public String describe() {
        return "The bird tilts its head and hops along its perch.";
    }

    // stretch goal 1
    @Override
    public String describeWithDetails() {
        return describe() + (canFly ? " It can fly." : " It can't fly.");
    }
}
