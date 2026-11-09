package java.java_assignment_07;

class Fish extends Animal {
    @Override
    void makeSound(){
        System.out.println("*Swimming Sounds*.");
    }

    @Override
    String describe(){
        return("The fish swims around the water, occasionally bumping onto rocks.");
    }

    void extraDescribe(){
        System.out.println("This fish has beautiful multicolored scales!");
    }
}