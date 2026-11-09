package AnimalPack;

public class Dog extends Animal {
    public static void main(String[] args) {
        System.out.println(makeSound());
        System.out.println(describe());
    }
    public static String makeSound(){
        return "Bark";
    }
    public static String describe(){
        return "A four legged animal that varies in sizes, they are domesticated, and they are furry and they bark";
    }
    public String toString() {
        return makeSound() + " - " + describe();
    }
}
