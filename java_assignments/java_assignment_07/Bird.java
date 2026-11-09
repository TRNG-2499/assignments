package java_assignments.java_assignment_07;

public class Bird extends Animal {

    public Bird(){
        super("Chirp! Chirp!", "The bird steals your bread and flies away!");
    }

    public Bird(Boolean canFly){
        String description = canFly ? "This bird can fly!" : "This bird can't fly!";
        super("Chirp! Chirp!", description);
    }
    
}
