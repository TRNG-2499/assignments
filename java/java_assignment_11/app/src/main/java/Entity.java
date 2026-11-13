public abstract class Entity {
  public Entity() {
    name = getClass().getName();
  }

  public final String getName() {
    return name;
  }

  // for use while in a room
  public abstract String interact(Room room);

  // for use while in inventory
  public abstract String interact(Player player);

  public abstract String getDescription();

  private final String name;
}
