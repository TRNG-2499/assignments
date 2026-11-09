package com.revature;

public abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String makeSound();

    public abstract String describe();

    // stretch goal 1
    public abstract String describeWithDetails();

    // shared here so every subclass is displayed the same way without repeating the print logic
    public void perform() {
        System.out.println(makeSound());
        System.out.println(describe());
    }
}
