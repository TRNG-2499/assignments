/**
 * An interactable object in a room. Names must be a single word (e.g.
 * "CoatRack").
 */
public class Entity {

    private final String name;
    private final String description;
    private final String interactResponse;

    public Entity(String name, String description, String interactResponse) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("This Entity cannot be empty");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("The Entity must be a single word \"" + name + "\"");
        }

        this.name = name;
        this.description = description;
        this.interactResponse = interactResponse;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /** Returns the text shown when the player interacts with this entity. */
    public String interact() {
        return interactResponse;
    }

    // Stretch goal: add a "takeable" flag for the take / inventory commands.
}
