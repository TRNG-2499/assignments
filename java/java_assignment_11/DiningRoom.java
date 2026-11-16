public class DiningRoom extends Room{


    Entity[] entities = {new Entity("Table", "The table is set with plates and utensils.")};

    public DiningRoom(){
        this.roomName = "DiningRoom";
        this.description = "A chandelier-lit dining room with a large table " +
                "and plenty of seats all around it.";
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
