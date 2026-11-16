public class Entity {
    private String name;
    private String description;
    public  Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String interact(){
        return switch (name.toLowerCase()) {
            case "television" -> "The television is turned on. Only static is shown.";
            case "toaster" -> "The toaster is unplugged.";
            case "coatrack" -> "There's an old raincoat hanging on it.";
            case "coffeemaker" -> "You pour yourself a cup of lukewarm coffee. It's very bitter.";
            case "refrigerator" -> "You open the refrigerator, think about what to eat, then close the door and decide on it later.";
            default -> "Nothing happens?";
        };
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
}
