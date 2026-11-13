public class LivingRoom extends Room{
    
    @Override
    public String name(){
        return "Living Room";
    }

    @Override
    public String description(){
        return "This is where you can watch TV";
    }

    @Override
    public Room moveTo(Direction d){
        return null;
    }
}
