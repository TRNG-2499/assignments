public class Parrot extends Animal {
  @Override
  public String makeSound() {
    return "Give me a cracker, tweet";
  }

  @Override
  public String describe() {
    return "tilts its head";
  }

  @Override
  protected String getName() {
    return "parrot";
  }
}
