import java.io.*;
import java.util.*;

public class InvalidDirectionException extends Exception {
    public InvalidDirectionException(){
        super("Invalid Direction; theres not room there!");
    }
}
