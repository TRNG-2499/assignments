import java.io.*;
import java.util.*;

public abstract class Room {

    public abstract String name();
    public abstract String description();

    public abstract Room moveTo(Direction d);
}