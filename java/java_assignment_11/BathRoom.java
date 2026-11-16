public class BathRoom extends Room{


    Entity[] entities = {new Entity("Sink", "The water running from it feels cold.")};

    public BathRoom(){
        this.roomName = "BathRoom";
        this.description = "A small bathroom with a toilet and sink.";
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
