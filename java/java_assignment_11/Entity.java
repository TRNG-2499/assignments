public class Entity {
    private String name;
    private String description;
    private String interactMsg;

    public Entity(String name, String description, String interactMsg){
        this.name = name;
        this.description = description;
        this.interactMsg = interactMsg;
    }

    public String getName(){return name;}
    public String getDescription(){return description;}
    public String interact(){return interactMsg;}
}
