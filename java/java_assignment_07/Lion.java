import java.io.*;
import java.util.*;

public class Lion extends Animal{
    
    @Override
    public String makeSound(){
        return "Groar!!";
    }

    @Override 
    public String describe(){
        return "This is one of the most well-known big cat species that hunt for large prey like zebras and giraffes in Africa";
    }
}
