package java_assignment_11;

public class Entity {
    private final String name;
    private final String description;
    private final String interactionResponse;

    public Entity(String name, String description, String interactionResponse) {
        if (name == null || name.trim().isEmpty() || name.matches(".*\\s+.*")) {
            throw new IllegalArgumentException("Entity name must be a single word.");
        }
        if (description == null) {
            throw new IllegalArgumentException("Entity description must not be null.");
        }
        if (interactionResponse == null) {
            throw new IllegalArgumentException("Entity interaction response must not be null.");
        }

        this.name = name;
        this.description = description;
        this.interactionResponse = interactionResponse;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String interact() {
        return interactionResponse;
    }
}
