public class Entity {

    String name;
    String description;

    public Entity(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public void interact(){
        System.out.println("You check the " + this.name + ". " + description);
    }

}
