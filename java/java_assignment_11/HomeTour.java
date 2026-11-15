package org.example;

import java.util.Scanner;

public class HomeTour {
    public static void main(String[] args) throws EntityNotFoundException, InvalidDirectionException {
        boolean exitB = false;


        mirror myMirror = new mirror("Mirror", "Reflective");
        couch myCouch = new couch("Couch", "For sitting multiple people");
        television myTV = new television("Television", "For watching programs");
        stove myStove = new stove("Stove", "For cooking food");
        sink mySink = new sink("Sink", "For cleaning yourself");
        bed myBed = new bed("Bed", "For sleeping");

        room foyer = new room("Foyer", "The entrance to the house", new String[]{"South"}, new entity[]{myMirror});
        room livingRoom = new room("LivingRoom", "A room for hangin' out", new String[]{"South","West","East","North"}, new entity[]{myTV, myCouch});
        room bedRoom = new room("BedRoom", "A room for sleeping", new String[]{"North","West"}, new entity[]{myBed});
        room bathRoom = new room("BathRoom", "A room for cleaning ones self", new String[]{"South","East"}, new entity[]{mySink});
        room kitchen = new room("Kitchen", "A room for cooking food", new String[]{"West"}, new entity[]{myStove});

        room currentRoom = foyer;

        Scanner myScan = new Scanner(System.in);
        String[] splited = new String[2];

        while (exitB != true) {
            System.out.println("Commands: move [direction] | look | interact [entity name] | exit |");
            System.out.println(currentRoom.name+", "+currentRoom.description);
            currentRoom.printItems();
            currentRoom.directions();

            String input = myScan.nextLine();

            splited = input.split(" ");

            switch(splited[0]) {
                case "interact":
                    if(!(currentRoom.contains(splited[1]))) {
                        throw new EntityNotFoundException();
                    } else {
                        switch(splited[1]) {
                            case "Mirror":
                                System.out.println(myMirror.interact());
                                break;
                            case "Couch":
                                System.out.println(myCouch.interact());
                                break;
                            case "Television":
                                System.out.println(myTV.interact());
                                break;
                            case "Stove":
                                System.out.println(myStove.interact());
                                break;
                            case "Sink":
                                System.out.println(mySink.interact());
                                break;
                            case "Bed":
                                System.out.println(myBed.interact());
                                break;
                        }
                    }
                case "look":
                    break;
                case "exit":
                    exitB = true;
                    break;
                case "move":
                    switch(currentRoom.name) {
                        case "Foyer":
                            switch(splited[1]) {
                                case "North":
                                    throw new InvalidDirectionException();
                                case "South":
                                    currentRoom = livingRoom;
                                    break;
                                case "East":
                                    throw new InvalidDirectionException();
                                case "West":
                                    throw new InvalidDirectionException();
                            }
                            break;
                        case "LivingRoom":
                            switch(splited[1]) {
                                case "North":
                                    currentRoom = foyer;
                                    break;
                                case "South":
                                    currentRoom = bedRoom;
                                    break;
                                case "East":
                                    currentRoom = kitchen;
                                    break;
                                case "West":
                                    currentRoom = bathRoom;
                                    break;
                            }
                            break;
                        case "BedRoom":
                            switch(splited[1]) {
                                case "North":
                                    currentRoom = livingRoom;
                                    break;
                                case "South":
                                    throw new InvalidDirectionException();
                                case "East":
                                    throw new InvalidDirectionException();
                                case "West":
                                    currentRoom = bathRoom;
                                    break;
                            }
                            break;
                        case "Kitchen":
                            switch(splited[1]) {
                                case "North":
                                    throw new InvalidDirectionException();
                                case "South":
                                    throw new InvalidDirectionException();
                                case "East":
                                    currentRoom = livingRoom;
                                    break;
                                case "West":
                                    throw new InvalidDirectionException();
                            }
                            break;
                        case "BathRoom":
                            switch(splited[1]) {
                                case "North":
                                    throw new InvalidDirectionException();
                                case "South":
                                    currentRoom = bedRoom;
                                    break;
                                case "East":
                                    currentRoom = livingRoom;
                                    break;
                                case "West":
                                    throw new InvalidDirectionException();
                            }
                            break;
                        default:
                            throw new InvalidDirectionException();
                    }
            }


        }
    }

}

class InvalidDirectionException extends Exception {
    public InvalidDirectionException() {
        super("Direction is not valid for this room");
    }
}

class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
        super("The entity you tried to interact with is not in this room");
    }
}


abstract class entity {
    public String name;
    public String description;
    abstract String interact();

    public entity(String name, String description) {
        this.name = name;
        this.description = description;
    }

}

class room {
    public String name;
    public String description;
    public String[] exits;
    public entity[] items;
    public room(String Rname, String Rdescription, String[] Rexits, entity[] Ritems) {
        name = Rname;
        description = Rdescription;
        exits = Rexits;
        items = Ritems;
    }
    public void printItems() {
        System.out.println("The room contains: ");
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i].name+", ");
        }
        System.out.println("");
    }
    public Boolean contains(String input) {
        boolean find = false;
        for(int i = 0; i < items.length; i++) {
            if(items[i].name.equals(input)) {
                find = true;
            }
        }
        return find;
    }
    public void directions() {
        System.out.println("You can move: ");
        for(int i = 0; i < exits.length; i++) {
            System.out.print(exits[i]+", ");
        }
        System.out.println("");
    }
}

class mirror extends entity {
    public String name = "Mirror";
    public String description = "A mirror that reflects light";

    public mirror(String myName, String desc) {
        super(myName, desc);
    }

    @Override
    public String interact() {
        return "You look into the mirror at your reflection. Lookin' good!";
    };

}

class couch extends entity {
    public String name = "Couch";
    public String description = "A soft couch made for sitting multiple people";

    @Override
    public String interact() {
        return "You take a load off on the couch. Comfy!";
    };
    public couch(String myName, String desc) {
        super(myName, desc);
    }

}

class television extends entity {
    public String name = "TV";
    public String description = "A flat electronic device used for watching various programs";

    @Override
    public String interact() {
        return "You turn on the TV and flip through a few channels before turning it off.";
    };
    public television(String myName, String desc) {
        super(myName, desc);
    }
}

class stove extends entity {
    public String name = "Stove";
    public String description = "Used for cooking";
    @Override
    public String interact() {
        return "You'd rather not try to cook something in someone else's home... so you just look at the stove for a moment.";
    };
    public stove(String myName, String desc) {
        super(myName, desc);
    }
}

class bed extends entity {
    public String name = "Bed";
    public String description = "A soft long piece of furniture used for sleeping";

    @Override
    public String interact() {
        return "You fall onto the bed and take a quick nap.";
    };
    public bed(String myName, String desc) {
        super(myName, desc);
    }
}

class sink extends entity {
    public String name = "Sink";
    public String description = "Used for cleaning, the faucet can emit cold or hot water";

    @Override
    public String interact() {
        return "You wash your hands.";
    };
    public sink(String myName, String desc) {
        super(myName, desc);
    }
}

