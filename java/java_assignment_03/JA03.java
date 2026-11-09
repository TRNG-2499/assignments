package java_assignment_03;

import java.util.Scanner;

public class JA03{

    private static final Scanner scanner = new Scanner(System.in);

    public static void report(String startColor, int ticks){
        switch (startColor){
            case "Yellow": ticks += 1; break;
            case "Red": ticks += 2; break;
        }

        int step = ticks % 3;
        switch (step){
            case 0: System.out.println("\nGreen"); break;
            case 1: System.out.println("\nYellow"); break;
            case 2: System.out.println("\nRed"); break;
        }
    }

    public static String get_color(){
        System.out.println("\nEnter start color:");
        String startColor = scanner.nextLine();
        return startColor;
    }

    public static int get_ticks(){
        System.out.println("\nEnter number of ticks: ");
        int ticks = scanner.nextInt();
        return ticks;
    }

    public static void main(String[] args){
        
        String startColor = get_color();
        if (!startColor.equals("Green") && !startColor.equals("Red") && !startColor.equals("Yellow")){
            System.out.printf("Invalid input: %s is not a recognized light color.", startColor);
            return;
        }

        int ticks = get_ticks();
        if (ticks < 0){
            System.out.println("Invalid input: tick count cannot be negative.");
            return;
        }

        scanner.close();

        report(startColor, ticks);
    }
}