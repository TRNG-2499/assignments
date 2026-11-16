package Entities;

public class Couch extends Entity {
    public String getName() {
        return "Couch";
    }

    public String getDesc() {
        return "A soft comfy couch.";
    }

    public void interact() {
        System.out.println("You sit on the couch, you sink into the seat as the soft cushion fabrics envelopes you.");
    }
}
