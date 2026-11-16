import java.util.Arrays;

public class Foyer extends Room{

    Entity[] entities = {new Entity("CoatRack", "There are a couple of coats hanging on it.")};

    public Foyer(){
        this.roomName = "Foyer";
        this.description = "The entranceway of the house. You can see the" +
                " kitchen in front of you.";
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

    @Override
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
