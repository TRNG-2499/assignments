public class LivingRoom extends Room {
  public LivingRoom() {
    addEntity(new TV());
    addEntity(new Candle());
  }

  @Override
  public String getDescription() {
    return "It's a well-furnished room for relaxing.";
  }
}
