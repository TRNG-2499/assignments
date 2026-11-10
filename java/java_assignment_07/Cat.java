public class Cat extends Animal {

    private static String fact = "To aid conservation and regulation, domestic cats are split into their own species rather than being listed as a subspecies.";

    public Cat() {
        super("Cat");
    }

    @Override
    public String makeSound() {
        return "meow";
    }

    @Override 
    public String describe() {
        return String.format(
            "Genus: Felis%nSpecies: Felis catus%n%s",
            fact
        );
    }
}
