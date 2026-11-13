public class Attic extends Room {
  public Attic() {
    lit = false;
  }

  public void light() {
    lit = true;
  }

  @Override
  public String getDescription() {
    return lit ? "It's cramped in here." : "It's too dark to see.";
  }

  private boolean lit;
}
