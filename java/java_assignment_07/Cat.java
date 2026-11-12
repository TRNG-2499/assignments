public class Cat extends Animal {

  @Override
  public void makeSound() {
    System.out.println("MEOW");
  }

  @Override
  public void describe() {
    System.out.println("Cats like to get sick on your bed!\n");
  }
}
