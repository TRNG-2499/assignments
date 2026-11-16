public class Main {
    public static void main(String[] args) {
        //Room foyer = new Room("Foyer", "The entrance to the house.");
        //Room kitchen = new Room("Kitchen", "A kitchen with a fridge.");

        House house = new House();
        Game game = new Game(house);
        game.start();




    //     foyer.addExit("north", kitchen);
    //     kitchen.addExit("south", foyer);

    //     foyer.addEntity(new Entity("CoatRack", "A sturdy wooden rack", "You check the CoatRack. There's an old raincoat hanging on it."));
    //     kitchen.addEntity(new Entity("Fridge", "A large refrigerator", "You open the fridge. It's full of fresh ingredients."));

    //     try {
    //         Room next = foyer.getExit("NORTH");
    //         System.out.println(next.describe());
    //         System.out.println(foyer.findEntity("coatrack").interact());
    //         foyer.getExit("south");
    //     } catch (InvalidDirectionException | EntityNotFoundException e) {
    //         System.out.println("An error occurred: " + e.getMessage());
    //     }
    // }
    }
}