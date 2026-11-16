import java.io.*;
import java.util.*;

public class InvalidDirectionException extends Exception {
    public InvalidDirectionException(String direction){
        super(String.format("There's no exit to the %s from here!", direction));
    }
}
