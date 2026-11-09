import java.util.SortedMap;
import java.util.TreeMap;

public abstract class Animal {
  public String getNameLowercase() {
    return getName().toLowerCase();
  }

  public String getNameCapitalized() {
    String name = getNameLowercase();
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

  public abstract String makeSound();

  public abstract String describe();

  public static void printInstructions() {
    // note that this will have the correct
    // ordering because the map is a SortedMap
    // and not a HashMap or regular Map
    for (var entry : ANIMAL_MAP.entrySet()) {
      System.out.printf("%d. %s%n", entry.getKey(), entry.getValue().getNameCapitalized());
    }

    System.out.println("0. Exit");
    System.out.println();
    System.out.print("> ");
  }

  public static Animal lookupAnimal(int value) {
    return ANIMAL_MAP.get(value);
  }

  protected abstract String getName();

  private static SortedMap<Integer, Animal> ANIMAL_MAP = new TreeMap<>();

  static {
    int current = 0;
    ANIMAL_MAP.put(++current, new Cat());
    ANIMAL_MAP.put(++current, new Dog());
    ANIMAL_MAP.put(++current, new Parrot());
  }
}
