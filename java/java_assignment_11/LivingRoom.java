public class LivingRoom extends Room{
    
    public LivingRoom(Room from, String exitDirection){
        super(from, exitDirection);
    }

    @Override
    public String name(){
        return "Living Room";
    }

    @Override
    public String description(){
        return "This is where you can watch TV";
    }

    @Override 
    protected Entity[] initEntities(){
        return new Entity[] {};
    }

    @Override
    protected Room initNorthRoom(){
        return new Bedroom(this, "north");
    }

    @Override
    protected Room initSouthRoom(){
        return new Kitchen(this, "south");
    }

    @Override
    protected Room initEastRoom(){
        return new Bathroom(this, "east");
    }

    @Override 
    protected Room initWestRoom(){
        return null;
    }

    @Override 
    protected Room initUpRoom(){
        return null;
    }

    @Override 
    protected Room initDownRoom(){
        return null;
    }
}
