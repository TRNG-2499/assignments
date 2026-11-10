public class Horse extends Animal {

    public static String fact = "I do not know any cool information about horses.";

    public Horse() {
        super("Horse");
    }

    @Override
    public String makeSound() {
        return "neigh";
    }

    @Override 
    public String describe() {
        return String.format(
            "Genus: Equus%nSpecies: Equus feris%nSubspecies: Equus feris caballus%n%s",
            fact
        );
    }
}
