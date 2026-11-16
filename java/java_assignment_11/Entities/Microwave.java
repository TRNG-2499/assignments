package Entities;

public class Microwave extends Entity {
    public String getName() {
        return "Microwave";
    }

    public String getDesc() {
        return "An old stained microwave that's still perfectly functional.";
    }

    public void interact() {
        System.out.println("You slipped a hotpocket into the microwave, come back in 2 minutes.");
    }
}
