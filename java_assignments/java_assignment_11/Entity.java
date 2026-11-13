public class Entity {
    private String name;
    private String description;
    private String interactionResponse;

    public Entity(String n, String d){
        //If theres a white space remove it from the name.
        if(n.matches(".*\\s.*")){
            this.name = n.replace(" ", "");
        } else {
            this.name = n;
        }
        this.description=d;
        this.interactionResponse = ("You check the "+name+". "+description+".");
    }

    public String getName(){
        return name;
    }
    

    public String getInteractionResponse(){
        return interactionResponse;
    }
}
