public class Dog extends Animal {

    private static String fact = "A dog's nose is built to repeatedly sample air by replacing air near the nose with each sniff.";

    public Dog() {
        super("Dog");
    }

    @Override
    public String makeSound() {
        return "bark";
    }

    @Override 
    public String describe() {
        return String.format(
            "Genus: Canis%nSpecies: Canis lupus%nSubspecies: Canis lupus familiaris%n%s",
            fact
        );
    }
}
