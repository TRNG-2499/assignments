public class Candle extends Entity {
  public Candle() {
    lit = false;
  }

  @Override
  public String interact(Room room) {
    if (lit && room instanceof Attic attic) {
      attic.light();
      return "The candle illuminates the attic.";
    }

    return lit ? "Ouch. That's hot!" : "The candle just sits there.";
  }

  @Override
  public String interact(Player player) {
    if (lit) {
      return "The candle is already burning.";
    }

    lit = true;
    return "You light the candle.";
  }

  @Override
  public String getDescription() {
    return lit ? "The candle glows fainltly" : "It's just a candle.";
  }

  public void light() {
    lit = true;
  }

  private boolean lit;
}
