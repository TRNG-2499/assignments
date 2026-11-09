package AnimalPack;

public class Bird extends Animal{
    public static void main(String[] args) {
        System.out.println(makeSound());
        System.out.println(describe());
    }
    public static String makeSound(){
        return "Sqwack";
    }
    public static String describe(){
        return "An Animal with feathers and wings with some variations that fly and some that don't.";
    }
    public String toString() {
        return makeSound() + " - " + describe();
    }
}
