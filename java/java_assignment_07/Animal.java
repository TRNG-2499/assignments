public abstract class Animal {

    private String name;
    
    public Animal(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public abstract String makeSound();

    public abstract String describe();
}
