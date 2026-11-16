package assignments.java.java_assignment_11;

import assignments.java.java_assignment_11.Exceptions.InvalidDirectionException;

public class EntryPoint {
    public static void main(String[] args) throws InvalidDirectionException {
        CommandLoop game = new CommandLoop();
        game.start();
    }
}

// TODO
    // stretch goal
    // add input validation for commands
    // make command display