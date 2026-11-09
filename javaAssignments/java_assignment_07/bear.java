package javaAssignments.java_assignment_07;

import java.util.Scanner;

public class bear extends animal{

    public bear(String sound, String description) {
        //the super  here lets us just pass the constructor up to the animal class
        super(sound, description);
    }

    @Override
    public void makeSound() {
        System.out.println(sound);
    }

    @Override
    public void describe() {
        System.out.println(description);
    }

    //stretch goal
    public boolean smash(){
        System.out.println("The bear is breaking the menu!");
        System.out.println("You need to be careful around the bear!");
        System.out.println("Choose an animal to hear its sounds: \n[1] Dog \n[2] Cat \n[3] Bear \n[0] Exit");
        for (int attempt = 0; attempt < 4; attempt++) {
            System.out.println("Get back to the start to get a new menu! Quick! Hit r to run!");
            Scanner sc = new Scanner(System.in);
            if (sc.next().equalsIgnoreCase("r")) {
                System.out.println("You made it back to the menu!");
                return true;
            }

            if (attempt == 0) {
                System.out.println("Cho se an animal to hea  its sou ds:\n[1] Do \n[2] Cat\n[3] B ar\n[0] Exit");
            } else if (attempt == 1) {
                System.out.println("Cho se an animal to hea  i s sou ds:\n[1] Do\n[2] Cat\n[3] B ar\n[0] Exit");
            } else if (attempt == 2) {
                System.out.println("Cho s  an animal t   ea  i   so  ds:\n[1] D g\n[2] Ca \n[3  B ar\n 0] E i ");
            } else {
                System.out.println("Cho s  a   nimal     ea      so  ds:\n[1] D \n[2   a \n[3  B  r\n  ] E  ");
            }
        }

        System.out.println("The bear destroyed the menu. Exiting the Zoo Soundboard.");
        return false;
    }
}
