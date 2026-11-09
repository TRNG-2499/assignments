package java.java_assignment_07;

class Cat extends Animal {
    @Override
    void makeSound(){
        System.out.println("Meow!");
    }

    @Override 
    String describe(){
        return("The cat lazily moves its tail as it looks at you with indifference.");
    }

    void extraDescribe(){
        System.out.println("This cat is orange and really like lasagna!");
    }
}
