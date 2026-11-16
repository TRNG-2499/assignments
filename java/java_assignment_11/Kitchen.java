public class Kitchen extends Room{

    Entity[] entities = {new Entity("Refrigerator", "There are some tupperware containers full of leftovers.")};


    public Kitchen(){
        this.roomName = "Kitchen";
        this.description = "The kitchen is brightly lit and smells of coffee.";
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
