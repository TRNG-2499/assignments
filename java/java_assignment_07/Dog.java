import java.io.*;
import java.util.*;

public class Dog extends Animal {

    @Override
    public String makeSound(){
        return "Woof!";
    }

    @Override
    public String describe(){
        return "It is a domestic mammal who can bark, sit, lay, and stay! It also loves playing with bones!!";
    }
}
