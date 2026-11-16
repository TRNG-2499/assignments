package Entities;

public class Bed extends Entity {
    public String getName() {
        return "Bed";
    }

    public String getDesc() {
        return "A large fluffy bed";
    }

    public void interact() {
        System.out.println("You lie down on the bed and start feeling sleepy.");
    }
}
