public class Bird extends Animal {

  @Override
  public void makeSound() {
    System.out.println("SCREAM");
  }

  @Override
  public void describe() {
    System.out.println("Birds have lots of feathers and weird tongues.\n");
  }
}
