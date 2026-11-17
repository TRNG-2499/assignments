/// an interactable object inside a room
/// names are a single word (e.g. "CoffeeMaker") so commands are easy to parse
class Entity {
    private final String name;
    private final String description;
    private final String response;   // what interact() returns

    public Entity(String name, String description, String response) {
        this.name = name;
        this.description = description;
        this.response = response;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    /// subclasses (like SlotMachine) can override this for custom behavior
    public String interact() {
        return response;
    }
}
