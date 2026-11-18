package HomeTour;
//submitted unfinished code because deadline was close, and I'm stuck.
import java.util.Scanner;

public class Entity {
    private String name;
    private String description;

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.name = description;
    }
    public String interact(){
        return "Interact with the " + name + ".";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String direction = scan.nextLine();

        Entity Room = new Entity("Foyer", "A small entryway with a coat rack and a stairway leading up.");

        System.out.println("Interactable entities: " + getEntities());

        while (true){
            System.out.println("You are in the " + Room.getName());
            System.out.println(Room.getDescription());
        }

    }
}

