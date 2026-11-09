package javaAssignments.java_assignment_07;

public abstract class animal {
    String sound;
    String description;

    //All args constructor
    public animal(String sound, String description) {
        this.sound = sound;
        this.description = description;
    }

    public abstract void makeSound();

    public abstract void describe();
}
