package java_assignments.java_assignment_07;

public abstract class Animal {

    private String sound;
    private String description;

    public Animal(String s, String d){
        this.sound = s;
        this.description = d;

    }

    public void makeSound(){
        System.out.println(sound);
    }

    public void describe(){
        System.out.println(description);
    }
    
    public String toString(){
        return sound +" "+ description;
    }
}
