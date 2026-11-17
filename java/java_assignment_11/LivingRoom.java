public class LivingRoom extends Room{
    
    public LivingRoom(){
        super();
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
        return new Entity[] {
            new FlaggedEntity("TV", "This TV is off", "This TV is off", "This TV is on", "You turned off the TV!", "You turned on the TV!")
        };
    }

    @Override
    protected Room initNorthRoom(){
        return null;
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
        return new Bedroom(this, "up");
    }

    @Override 
    protected Room initDownRoom(){
        return null;
    }
}
