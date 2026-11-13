import java.io.*;
import java.util.*;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(){
        super("Entity not present");
    }
}