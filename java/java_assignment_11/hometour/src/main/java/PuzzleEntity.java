public class PuzzleEntity extends Entity {
    private boolean interacted = false;
    private String newResponse;
    private Entity item;

    public PuzzleEntity(String name, String description, String response, String newResponse, Entity item) {
        super(name, description, response, false);
        this.newResponse = newResponse;
        this.item = item;
    }

    @Override 
    public String interact() {
        if (interacted) return this.newResponse;
        
        Player.revealEntity(item);
        interacted = true;
        return this.response;
    }
}
