public class Cat extends Animal {

  @Override
  public void makeSound() {
    System.out.println("Meow! Meow!");
  }

  @Override
  public void describe() {
    System.out.println("The cat stretches and purrs softly at you.");
  }
}