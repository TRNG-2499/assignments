//class is defined with at least a name, a description, and an interaction response
//Entity names are single words, with no spaces
public class entity {
    private String name;
    private String description;
    private String interactionResponse;

    public entity(String name, String description, String interactionResponse) {
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

    public String getInteractionResponse() {
        return interactionResponse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInteractionResponse(String interactionResponse) {
        this.interactionResponse = interactionResponse;
    }
}
