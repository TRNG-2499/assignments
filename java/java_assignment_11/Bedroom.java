package java_assignment_11;


public class Bedroom extends Room {

    public Bedroom() {
        super("Bedroom");
    }

    @Override
    public String getDescription() {
        return "A quiet bedroom with a soft bed and a bedside table.";
    }
}
