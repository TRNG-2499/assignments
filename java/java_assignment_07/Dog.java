public class Dog extends Animal {
  @Override
  public String makeSound() {
    return "Woof woof";
  }

  @Override
  public String describe() {
    return "wags its tail";
  }

  @Override
  protected String getName() {
    return "dog";
  }
}
