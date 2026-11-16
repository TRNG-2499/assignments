public class DoorEntity extends Entity {
    private Entity key;

    public DoorEntity(String name, String description, Entity key) {
        super(name, description, "", false);
        this.key = key;
    }

    @Override 
    public String interact() {
        if (!Player.has(key)) return "This door is locked, you'll need to find a key.";
        
        Player.unlockRoom();
        return "The door has been unlocked!";
    }
}
