public class Bird extends Animal {

    @Override
    public String makeSound() {
        return "Tweet! Tweet!";
    }

    @Override
    public String describe() {
        return "The bird tilts its head and hops along its perch.";
    }
}