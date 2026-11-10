public class Bird extends Animal{

    private String canFly;

    public Bird(){

    }

    public Bird(String canFly) {
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet !");
    }

    @Override
    public void describe() {
        System.out.println("The bird tilts its head and hops along its perch. What about flying? " + canFly);
    }
}

