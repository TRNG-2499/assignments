import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class a6_solution {
    public void solution(){
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        double total = 0;
        String lastCommand = "";
        double lastNumber = 0;
        List<String> history =  new ArrayList<String>();
        while(!stop){
            System.out.print("Enter a command: ");
            String command = sc.nextLine();
            String[] commandLine =  command.split(" "); // this is done to prevent looping error
            String tempArray[];
            switch(commandLine[0]){
                case "add":
                    total = addHelper(commandLine,total);
                    break;
                case "subtract":
                    total = subHelper(commandLine,total);
                    break;
                case "total":
                    System.out.println("Current total: " + total);
                    break;
                case "reset":
                    lastNumber = total;
                    total = 0;
                    System.out.println("Running total has been set to 0.");
                    break;
                case  "exit":
                    System.out.println("Goodbye! Final total: " + total);
                    stop = true;
                    break;
                // Stretch Goals
                case "history":
                    for(String h: history){
                        System.out.println(h);
                    }
                    break;
                case "undo":
                    switch (lastCommand){
                        case "add":
                            tempArray = new String[]{"subtract", String.valueOf(lastNumber)};
                            total = subHelper(tempArray,total);
                            break;
                        case "subtract":
                            tempArray = new String[]{"add", String.valueOf(lastNumber)};
                            total = addHelper(tempArray,total);
                            break;
                        case "reset":
                            total = lastNumber;
                            System.out.println("Total has been restored. Running total: " + total);
                            break;
                        default:
                            System.out.println("Nothing to undo.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Unrecognized command: " + commandLine[0]);
            }
            history.add(Arrays.toString(commandLine));
            lastCommand = undoHelper(commandLine);
            if(lastCommand.equals("add") || lastCommand.equals("subtract")){
                lastNumber = Double.parseDouble(commandLine[1]);
            }
        }
        sc.close();
    }

    public double addHelper(String[] commandLine, double total){
        if(commandLine.length == 1){
            System.out.println("'add' requires a valid number. Please try again.");
        }
        else{
            try{
                double num = Double.parseDouble(commandLine[1]);
                total += num;
                System.out.println("Added " + num + ". Running total: " + total);
            } catch(NumberFormatException e){
                System.out.println("'add' requires a valid number. Please try again.");
            }
        }
        return total;
    }
    public double subHelper(String[] commandLine, double total){
        if(commandLine.length == 1){
            System.out.println("'subtract' requires a valid number. Please try again.");
        }
        else{
            try{
                double num = Double.parseDouble(commandLine[1]);
                total -= num;
                System.out.println("Subtracted " + num + ". Running total: " + total);
            } catch(NumberFormatException e){
                System.out.println("'subtract' requires a valid number. Please try again.");
            }
        }
        return total;
    }
    public String undoHelper(String[] commandLine){
        if(commandLine.length == 1 && !commandLine[0].equals("reset")){
            return "empty";
        }
        return commandLine[0];
    }

    public static void main(String[] args) {
        a6_solution s = new a6_solution();
        s.solution();
    }
}
