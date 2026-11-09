package assignment02.part07;

public class Dog extends Animal {

    private String breed;

    public Dog(String breed){
        this.breed = breed;
    }

    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }


    @Override
    public void makeSound(){
        System.out.println("Woof Woof");
    }
    @Override 
    public void describe(){
        System.out.println("The " + breed + " wags its tail excitedly and looks up at you.");
    }
}
