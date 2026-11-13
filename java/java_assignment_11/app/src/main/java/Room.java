import java.util.ArrayList;
import java.util.List;

public abstract class Room {
  public Room() {
    name = getClass().getName();
    entities = new ArrayList<>();
  }

  public final List<Entity> getEntities() {
    return entities;
  }

  public void addEntity(Entity e) {
    entities.add(e);
  }

  public void removeEntity(Entity e) {
    entities.remove(e);
  }

  public final String getName() {
    return name;
  }

  public Room getInDirection(Direction d) throws NoConnectionException {
    switch (d) {
      case down:
        return getDown();
      case east:
        return getEast();
      case north:
        return getNorth();
      case south:
        return getSouth();
      case up:
        return getUp();
      case west:
        return getWest();
      default:
        throw new NoConnectionException();
    }
  }

  public Room getNorth() throws NoConnectionException {
    if (north == null) {
      throw new NoConnectionException();
    }
    return north;
  }

  public Room getSouth() throws NoConnectionException {
    if (south == null) {
      throw new NoConnectionException();
    }
    return south;
  }

  public Room getEast() throws NoConnectionException {
    if (east == null) {
      throw new NoConnectionException();
    }
    return east;
  }

  public Room getWest() throws NoConnectionException {
    if (west == null) {
      throw new NoConnectionException();
    }
    return west;
  }

  public Room getUp() throws NoConnectionException {
    if (up == null) {
      throw new NoConnectionException();
    }
    return up;
  }

  public Room getDown() throws NoConnectionException {
    if (down == null) {
      throw new NoConnectionException();
    }
    return down;
  }

  public void setNorth(Room other) {
    if (north == null && other.south == null) {
      north = other;
      other.south = this;
    }
  }

  public void setSouth(Room other) {
    other.setNorth(this);
  }

  public void setEast(Room other) {
    if (east == null && other.west == null) {
      east = other;
      other.west = this;
    }
  }

  public void setWest(Room other) {
    other.setEast(this);
  }

  public void setUp(Room other) {
    if (up == null && other.down == null) {
      up = other;
      other.down = this;
    }
  }

  public void setDown(Room other) {
    other.setUp(this);
  }

  public abstract String getDescription();

  private Room north;
  private Room south;
  private Room east;
  private Room west;
  private Room up;
  private Room down;

  private List<Entity> entities;

  private final String name;
}
