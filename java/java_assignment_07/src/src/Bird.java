public class Bird extends Animal {
    boolean canFly;

    Bird(boolean canFly){
        this.canFly = canFly;
    }

    @Override
    void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    void describe() {
        String fly = "";
        if(!canFly){
            fly = "not ";
        }
        System.out.println("The bird tilts its head and hops along its perch. This one is " + fly + "able to fly.");
    }
}
