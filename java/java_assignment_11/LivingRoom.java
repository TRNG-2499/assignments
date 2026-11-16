import Entities.Entity;

public class LivingRoom extends Room {
    private final String name = "Living Room";
    private final String description = "A warm spacious living room with couches and a TV.";

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }
}
