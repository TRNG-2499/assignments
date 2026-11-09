import java.io.*;
import java.util.*;

public class Frog extends Animal {

    @Override
    public String makeSound(){
        return "Ribbit!";
    }

    @Override
    public String describe(){
        return "This is one of the most common amphibean species that can make multiple leaps above lillypads and lay clusters of slimy eggs";
    }
}