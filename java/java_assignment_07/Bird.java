public class Bird extends Animal {

    private boolean canFly;

    public Bird(String name, boolean canFly) {
        super(name);
        this.canFly = canFly;
    }

    public void  makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    public void describe() {
        System.out.println(name + " this  bird tilts its head and hops along it prech");
    }

    public boolean canFlyBird() { return canFly; }
}
