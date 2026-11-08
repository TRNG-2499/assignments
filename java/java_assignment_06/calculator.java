/*
# Command-Based Calculator

## Objective

Practice using `Scanner` to read repeated input from the console inside a loop, parsing a line of input into a command and an argument, 
and maintaining state (a running value) across iterations until an exit condition is met.
## Example Interactions

```
Enter a command: add 5
Added 5. Running total: 5

Enter a command: add 10
Added 10. Running total: 15

Enter a command: subtract 3
Subtracted 3. Running total: 12

Enter a command: total
Current total: 12

Enter a command: reset
Running total has been reset to 0.

Enter a command: fly 5
Unrecognized command: 'fly'

Enter a command: add banana
'add' requires a valid number. Please try again.

Enter a command: exit
Goodbye! Final total: 0
```

## Requirements Checklist

- [ ] Loop continues reading commands until `exit` is entered
- [ ] `add [number]` correctly increases the running value and reports the update
- [ ] `subtract [number]` correctly decreases the running value and reports the update
- [ ] `reset` correctly sets the running value back to 0
- [ ] `total` correctly displays the current value without altering it
- [ ] Unrecognized commands are handled gracefully, with a clear message, and do not crash the program
- [ ] Missing or non-numeric arguments to `add`/`subtract` are handled gracefully, with a clear message, and do not crash the program
- [ ] Program prints a final farewell message and the final value upon `exit`
- [ ] Code is organized into at least one clearly named method beyond `main` (e.g., a method to parse and handle a single command)
*/

/*## Instructions

- Write a program that maintains a running numeric value, as an `int`, starting at `0`.
- In a loop, prompt the user to enter a command. Support the following commands:
  - `add [number]` — adds the given number to the running value
  - `subtract [number]` — subtracts the given number from the running value
  - `reset` — resets the running value back to `0`
  - `total` — prints the current running value, without changing it
  - `exit` — ends the program
- After each command (other than `exit`), print a confirmation message along with the updated running value. `total` should simply print the current value, without implying any change occurred.
- The loop should continue until the user enters `exit`, at which point the program should print a final farewell message along with the final running value, and then stop.
- Handle an unrecognized command gracefully, with a clear error message, rather than crashing the program.
- Handle an `add` or `subtract` command that is missing its number, or whose argument is not a valid number, gracefully, with a clear error message, rather than crashing the program.
- Each command will be entered as a single line of input (for example, `add 5`). You will need to split this line into the command word and its argument (if any) in order to process it — this is a good opportunity to practice parsing a raw line of text into usable pieces, a pattern you will see again in later activities.
*/

import java.util.Scanner;

public class calculator {


    public static void main(String args[]){

        Scanner myObj = new Scanner(System.in);
        String input = "";
        int value = 0;

        while(!input.equals("exit")){

            System.out.println("Insert command:");
            input = myObj.nextLine();

            if(input.equals("exit")){
                System.out.println("End of program");
                break;
            } else{

                value = calc(input, value);
            }
        }
        
        myObj.close();


    }


    public static int calc(String input, int v){
        
        //Check if it has 2 args (length)
        //Check if the 2nd arg is an integer

        String[] inputs = input.split(" ");

        String output = "hey";

        if(inputs.length == 1){
            
            switch(inputs[0]){
            case "total":
                output = String.format("Running total: %d", v);
                break;

            case "reset":
                v = 0;
                output = String.format("Running total has been set to %d", v);
                break;
            
            default:
                output = "Not enough arguments. Format: command value";
                break;
            }

        }
        else if (inputs.length > 2) {
            output = "Improper formatting. Format: command value";
        }
        else{

            String cmd = inputs[0];
            String val = inputs[1];

            if(is_int(val)){

            int val_num = Integer.parseInt(val);

            switch(cmd){
            case "add":
                v += val_num;
                output = String.format("Added %d. Running total %d", val_num, v);
                break;
            
            case "subtract":
                v -= val_num;
                output = String.format("Subtracted %d. Running total %d", val_num, v);
                break;
            
            default:
                output = String.format("Unrecognized command: %s. Valid commands: add/subtract/total/reset/exit", cmd);
                break;
                
            }
            } 
            else{
                output = "Second argument must be an integer. Format: command value";}
            }

        System.out.println(output);
        return v;

    }


    public static boolean is_int(String s){

        char[] ints = {'0','1','2','3','4','5','6','7','8','9'};

        boolean found = false;
        
        for(int i = 0; i < s.length(); i++){

            found = false;

            for(int j = 0; j < ints.length; j++){

                if (s.charAt(i) == ints[j]){
                    found = true;
                }

            }
            if(!found){
                return false;
            }
        }
        return true;
    }



    
}
