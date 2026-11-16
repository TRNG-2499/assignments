public class Entities { 
  private final String name;
  private final String description;
  private final String response;

  public Entities(String name, String description, String response) {
        this.name = name;
        this.description = description;
        this.response = response;
  }
  public String getName() {
        return name;
  }
  public String getDescription() {
        return description;
  }
  public String interact() {
        return response;
  }
}
