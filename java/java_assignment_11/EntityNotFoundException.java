import java.io.*;
import java.util.*;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entityName){
        super(String.format("There is no \'%s\' here to interact with!", entityName));
    }
}