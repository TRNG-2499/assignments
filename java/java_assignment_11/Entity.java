package assignments.java.java_assignment_11;

public class Entity {

    private String name;
    private String description;

    public Entity(String n, String d){
        name = n;
        description = d;
    }

    public String getName(){
        return name;
    }

    public String interact() {
        return description;
    }

}
