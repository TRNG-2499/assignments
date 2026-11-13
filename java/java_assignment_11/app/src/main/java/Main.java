import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Room r = generate();
    Player p = new Player();

    describe(r);

    outer: while (true) {
      System.out.print("> ");
      String input = s.nextLine().toLowerCase();

      // move
      if (input.startsWith("move ")) {
        try {
          Direction d = Direction.valueOf(input.substring(5));

          try {
            r = r.getInDirection(d);
          } catch (NoConnectionException e) {
            System.out.printf("%s %s%n", d, e.getMessage());

          }

          describe(r);
        } catch (IllegalArgumentException e) {
          System.out.println("Invalid direction.");
        }
      }
      // look
      else if (input.equals("look")) {
        describe(r);
      }
      // interact
      else if (input.startsWith("interact ")) {
        try {
          for (Entity e : r.getEntities()) {
            if (e.getName().toLowerCase().equals(input.substring(9))) {
              System.out.println(e.interact(r));
              continue outer;
            }
          }
          throw new NoSuchEntityException(input.substring(9));
        } catch (NoSuchEntityException e) {
          System.out.println(e.getMessage());
        }
      }
      // quit
      else if (input.equals("quit") || input.equals("exit")) {
        break;
      }

      System.out.println();
    }

    s.close();

  }

  private static void describe(Room r) {
    System.out.println(r.getName());
    System.out.println(r.getDescription());
    System.out.println();
    for (Entity e : r.getEntities()) {
      System.out.printf("%s - %s%n", e.getName(), e.getDescription());
    }
  }

  private static Room generate() {
    Room center = new LivingRoom();
    center.setUp(new Attic());
    Room kitchen = new Kitchen();
    center.setEast(kitchen);
    kitchen.setNorth(new Dining());
    return center;
  }
}
