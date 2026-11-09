package AnimalPack;

public class Cat extends Animal{
    public static void main(String[] args) {
        System.out.println(makeSound());
        System.out.println(describe());
    }
    public static String makeSound(){
        return "Purr and Meow";
    }
    public static String describe(){
        return "A small four legged animal that has fur, is domesticated and they purr and meow";
    }
    public String toString() {
        return makeSound() + " - " + describe();
    }
}
