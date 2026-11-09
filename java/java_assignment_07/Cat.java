public class Cat extends Animal {
  @Override
  public String makeSound() {
    return "Meow";
  }

  @Override
  public String describe() {
    return "arches its back";
  }

  @Override
  protected String getName() {
    return "cat";
  }
}
