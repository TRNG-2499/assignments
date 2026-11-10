// extends Bird with a canFly field, without changing Bird itself
public class DetailedBird extends Bird {

    private boolean canFly;

    public DetailedBird(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public void describe() {
        super.describe(); // keeps the original description
        if (canFly) {
            System.out.println("It can fly.");
        } else {
            System.out.println("It can't fly.");
        }
    }
}