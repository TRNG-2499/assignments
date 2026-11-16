public class LivingRoom extends Room{


    Entity[] entities = {new Entity("TV", "The TV is currently off.")};

    public LivingRoom(){
        this.roomName = "LivingRoom";
        this.description = "A medium-sized room with a large sofa and a " +
                "large TV opposite of it.";
    }

    public String getName(){
        return this.roomName;
    }

    public String getDescription(){
        return this.description;
    }

    public Entity[] getEntities(){
        return this.entities;
    }

    public void look(){
        System.out.println("You are currently in the " + getName());
        System.out.println(getDescription());
        System.out.print("Interactable Items: ");

        for(int j = 0; j < entities.length; j++){
            System.out.print(entities[j].getName());
        }

        System.out.print("\n");

    }
}
