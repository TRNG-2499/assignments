public class Knife extends Entity {
  @Override
  public String interact(Room room) {
    return "The knife is sharp.";
  }

  @Override
  public String interact(Player player) {
    return "You accidentally cut yourself.";
  }

  @Override
  public String getDescription() {
    return "A short knife meant for chopping fruit and vegetables.";
  }
}
