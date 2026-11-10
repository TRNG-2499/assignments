public class Cat extends Animal {
    private String color;

    public Cat(){

    }

    public Cat(String color){
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println("Cat looks at you so innocently and then stretches and purrs softly.It's color is " + color);
    }
}
