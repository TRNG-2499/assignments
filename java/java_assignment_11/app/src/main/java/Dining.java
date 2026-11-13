public class Dining extends Room {
  public Dining() {
    addEntity(new Table());
  }

  @Override
  public String getDescription() {
    return "A room meant for eating food. It smells of a recent meal.";
  }
}
