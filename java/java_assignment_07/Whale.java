import java.io.*;
import java.util.*;

public class Whale extends Animal {

    @Override
    public String makeSound(){
        return "WwwwwwhhhhhhoooooOOOOOOOO!";
    }

    @Override
    public String describe(){
        return "This large sea creature can make deep large underwater sounds but have poor eyesight.";
    }
}