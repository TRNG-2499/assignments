// extends Dog with a breed, without changing Dog itself
public class DetailedDog extends Dog {

    private String breed;

    public DetailedDog(String breed) {
        this.breed = breed;
    }

    @Override
    public void describe() {
        super.describe(); // keeps the original description
        System.out.println("Breed: " + breed);
    }
}