package assignments.java.java_assignment_07;

public class Cat extends Animal {
    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println("The cat licks its paws and runs away.");
        System.out.println("This cat is " + age + " years old.");
    }
}