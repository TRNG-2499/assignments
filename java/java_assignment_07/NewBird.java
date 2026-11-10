public class NewBird extends Bird{
    boolean canFly = true;

    @Override
    void describe(){
        System.out.println("The bird tilts its head along its perch, then does a somersault to impress you.");
    }
}
