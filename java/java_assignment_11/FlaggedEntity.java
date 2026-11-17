import java.io.*;
import java.util.*;

public class FlaggedEntity extends Entity {
    private boolean flag;

    private String offDescription, onDescription;
    private String offInteract, onInteract;

    public FlaggedEntity(String name, String description, String offDescription, String onDescription, String offInteract, String onInteract){
        super(name, description);
        this.offDescription = offDescription;
        this.onDescription = onDescription;
        
        this.offInteract = offInteract;
        this.onInteract = onInteract;
    }

    @Override
    public String interact(){
        this.flag = !flag;
        if(flag){
            this.description = onDescription;
            return this.onInteract;
        } else {
            this.description = offDescription;
            return this.offInteract;
        }
    }
}
