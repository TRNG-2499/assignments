public class Kitchen extends Room {
  public Kitchen() {
    addEntity(new Knife());
  }

  @Override
  public String getDescription() {
    return "It's a place for cooking food.";
  }
}
