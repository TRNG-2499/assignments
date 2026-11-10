public class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.name = breed;
    }

    @Override 
    public void makeSound() {
        System.out.println("Woof Woof!");
    }

    @Override 
    public void describe() {
        System.out.println(name + " the dog wags its tail excitedly and looks up at you.");
    }

    public String getBreed() { return  breed; }
}
