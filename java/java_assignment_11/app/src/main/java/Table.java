public class Table extends Entity {
  @Override
  public String interact(Room room) {
    return "You sit down at the table.";
  }

  @Override
  public String interact(Player player) {
    return "This is heavy. Maybe I should put it down.";
  }

  @Override
  public String getDescription() {
    return "A fancy wooden table with inscribed patterns.";
  }
}
