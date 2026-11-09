package java.java_assignment_07;

class Bird extends Animal {
    @Override
    void makeSound(){
        System.out.println("Squak!");
    }

    @Override
    String describe(){
        return("The bird flies and lands on top of your head.");
    }

    void extraDescribe(){
        System.out.println("This bird is a rather loud parrot!");
    }
}