package java_assignment_11;


public class Kitchen extends Room {

    public Kitchen() {
        super("Kitchen");
    }

    @Override
    public String getDescription() {
        return "A bright kitchen with the smell of fresh coffee.";
    }
}
