import java.util.Scanner;
public class zooAnimalSoundsGP {
    public static void main(String args[]) {
        Dog myDog = new Dog();
        Cat myCat = new Cat();
        Fish myFish = new Fish();
        Scanner myScan = new Scanner(System.in);
        Boolean leave = false;
        System.out.println("|1 - Dog | 2 - Cat | 3 - Fish | 0 - Exit |");
        while(leave != true) {
            String input = myScan.nextLine();
            switch(input) {
                case "1":
                    System.out.println(myDog.makeNoise());
                    System.out.println(myDog.describe());
                    break;
                case "2":
                    System.out.println(myCat.makeNoise());
                    System.out.println(myCat.describe());
                    break;
                case "3":
                    System.out.println(myFish.makeNoise());
                    System.out.println(myFish.describe());
                    break;
                case "0":
                    System.out.println("Bye!");
                    leave = true;
                    break;
                default:
                    System.out.println("Please input a valid number");
            }
        }
        myScan.close();
    }
}

abstract class Animal {
    abstract String makeNoise();
    abstract String describe();
}

class Dog extends Animal {
    public String makeNoise() {
        return "Woof!";
    }
    public String describe() {
        return "A dog has 4 legs, a tail, and is man's best friend!";
    }
}

class Cat extends Animal {
    public String makeNoise() {
        return "Meow!";
    }
    public String describe() {
        return "A cat has 4 legs, a tail, and is a small, sneaky pet to many.";
    }
}

class Fish extends Animal {
    public String makeNoise() {
        return "Blub... blub...";
    }
    public String describe() {
        return "A fish is a water-breathing, scaled animal that swims all throughout the earth.";
    }
}
