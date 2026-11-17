import java.util.Scanner;
import java.util.Random;

class Entity {
    private String Name = "name";
    private static String Description = "description";

    public String getName() {
        return this.Name;
    }
    public String getDescription() {
        return Description;
    }

    public static void interact() {
        System.out.println("Generic interact() method called");
    }
}
