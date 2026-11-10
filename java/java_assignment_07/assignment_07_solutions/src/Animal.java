public abstract class Animal {
    abstract String makeSound();
    abstract String describe();
}

class Dog extends Animal {
    @Override
    String makeSound() {
        return "Bark!";
    }
    @Override
    String describe() {
        return "I am a dog.";
    }
}

class DogStretch extends Dog {
    private String breed;

    DogStretch() {
        this("Default K9");
    }
    DogStretch(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return this.breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
}

class Cat extends Animal {
    @Override
    String makeSound() {
        return "Meow!";
    }
    @Override
    String describe() {
        return "I am a cat.";
    }
}

class CatStretch extends Cat {
    private String color;

    CatStretch() {
        this("Default black");
    }
    CatStretch(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

}

class Bird extends Animal {
    @Override
    String makeSound() {
        return "Chirp!";
    }
    @Override
    String describe() {
        return "I am a bird.";
    }
}

class BirdStretch extends Bird {
    private boolean canFly;

    BirdStretch() {
        this(false);
    }
    BirdStretch(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean getCanFly() {
        return this.canFly;
    }
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}