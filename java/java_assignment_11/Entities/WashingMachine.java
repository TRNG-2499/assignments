package Entities;

public class WashingMachine extends Entity {
    public String getName() {
        return "WashingMachine";
    }

    public String getDesc() {
        return "A high tech washing machine";
    }

    public void interact() {
        System.out.println("You stare at the washing machine. You don't have any laundry to do yet.");
    }
}
