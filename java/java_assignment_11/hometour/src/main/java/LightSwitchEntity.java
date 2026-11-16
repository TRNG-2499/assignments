public class LightSwitchEntity extends Entity {

    public LightSwitchEntity(String name, String description) {
        super(name, description, "", false);
    }

    @Override
    public String interact() {
        if (Player.switchLight(this)) {
            return "Click! The room's lighting changes.";
        }
        return "Nothing happens.";
    }
}
