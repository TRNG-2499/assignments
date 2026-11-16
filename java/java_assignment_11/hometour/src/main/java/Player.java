import java.util.HashSet;
import java.util.Set;

public class Player {
    private static Room location;
    private static Set<Entity> inventory = new HashSet<>();

    public static boolean take(Entity e) {
        if(e.canTake() && !inventory.contains(e) && location.getEntities().contains(e)) {
            location.takeEntity(e);
            inventory.add(e);
            return true;
        }
        return false;
    }
    

    public static boolean place(Entity e) {
        if(inventory.contains(e) && !location.getEntities().contains(e)) {
            inventory.remove(e);
            location.addEntity(e);
            return true;
        }
        return false;
    }

    public static Set<Entity> getInventory() {
        return inventory;
    }

    public static Room getLocation() {
        return location;
    }

    public static boolean changeRoom(Room newRoom) {
        location = newRoom;
        return true;
    }

    public static boolean revealEntity(Entity e) { 
        location.addEntity(e);
        return true;
    }

    public static boolean switchLight(Entity e) {
        if (e.getName().equalsIgnoreCase("LightSwitch") && location instanceof DarkRoom) {
            ((DarkRoom)location).toggleLight();
            return true;
        }
        return false;
    }

    public static boolean has(Entity e) {
        return inventory.contains(e);
    }

    public static boolean unlockRoom() {
        if (location instanceof LockedRoom lockedRoom) {
            lockedRoom.unlock();
            return true;
        }
        return false;
    }

    public static Entity getEntityByName(String name) {
    if (name == null) return null;
    for (Entity e : inventory) {
        if (e.getName().equalsIgnoreCase(name.trim())) return e;
    }
    return null;
}
}
