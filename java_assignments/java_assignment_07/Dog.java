package java_assignments.java_assignment_07;

public class Dog extends Animal {

    public Dog() {
        super("Bark! Bark!", "Sits and begs for food.");
    }

    public Dog(String breed){
        super("Bark! Bark!", "Breed: "+breed);
    }
}
