public class Cat extends Animal {
    
    private boolean isIndoor;

    public Cat(String name, boolean isIndoor) {
        super(name);
        this.isIndoor = isIndoor;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println(name + " the cat purrs contentedly and stretches its paws.");
    }

    public boolean isIndoorCat() { return isIndoor; }
}
