//ticks
import java.util.Scanner;


public class java_assignment_03solution{
//Lights and ticks



public static void main(String[] args){

Scanner myObj = new Scanner(System.in);

String quit = "N";

while(!quit.equals("Y")){
System.out.println("Starting light color");
String color = myObj.nextLine();


System.out.println("Ticks");
int ticks = myObj.nextInt();
myObj.nextLine();

String result = end_light(color, ticks);
System.out.println(result);

System.out.println();
System.out.println("Quit? (Y to exit)");
quit = myObj.nextLine();


}

}

public static String end_light(String c, int t){

    c = c.toUpperCase();
    int state = 1;

    if(t < 0){
        return "Ticks cannot be negative";
    }

    switch(c){
        case "GREEN":
        state = 1;
        break;

        case "YELLOW":
        state = 2;
        break;

        case "RED":
        state = 3;
        break;

        default:
            return String.format("Invalid input. %s is not a recognized color.", c);
    }

    state = (state + t) % 3;
    
    switch(state){
        case 1:
            return "Green";
        case 2:
            return "Yellow";
        case 0:
            return "Red";
        default:
            return "Uh oh";

    }

}

}