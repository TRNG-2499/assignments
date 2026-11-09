package java.java_assignment_07;

class Dog extends Animal{
    @Override 
    void makeSound(){
        System.out.println("Woof Woof!");
    }

    @Override
    String describe(){
        return("The dog wags its tail happily as it smiles at you.");
    }

    void extraDescribe(){
        System.out.println("This dog is a German Shepard!");
    }
}