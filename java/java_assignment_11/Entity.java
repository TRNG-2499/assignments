package assignments.java.java_assignment_11;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Entity {
    private final String name;
    @Setter
    private String description;
    @Setter
    private String interaction;

    public Entity(String name, String description, String interaction) {
        if (name == null || name.isBlank() || name.matches(".*\\s+.*")) {
            throw new IllegalArgumentException(
                    "Entity name must be a single word.");
        }

        this.name = name;
        this.description = description;
        this.interaction = interaction;
    }

    public String interact() {
        return interaction;
    }
}