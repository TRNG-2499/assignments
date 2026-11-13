import java.util.ArrayList;
import java.util.List;

public class Player {
  public Player() {
    items = new ArrayList<>();
  }

  public void addItem(Entity item) {
    items.add(item);
  }

  public void removeItem(Entity item) {
    items.remove(item);
  }

  public List<Entity> getItems() {
    return items;
  }

  private List<Entity> items;
}
