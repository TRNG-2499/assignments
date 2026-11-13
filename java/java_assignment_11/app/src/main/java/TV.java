public class TV extends Entity {
  public TV() {
    on = false;
  }

  @Override
  public String interact(Room room) {
    on = !on;
    return on ? "The TV turns on." : "The TV turns off.";
  }

  @Override
  public String interact(Player player) {
    return "It's really heavy.";
  }

  @Override
  public String getDescription() {
    return on ? "Just static. There's no signal." : "It's off.";
  }

  private boolean on;
}
