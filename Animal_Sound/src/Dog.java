public class Dog extends Animal{

    private String breed;

    public Dog(){

    }

    public Dog(String breed){
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void describe() {
        System.out.println("The dog wags its tail excitedly and looks up at you. It's breed is:  " + breed);
    }
}
