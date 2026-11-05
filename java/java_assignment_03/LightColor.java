public enum LightColor {
  Green(3),
  Yellow(1),
  Red(2);

  public LightColor next() {
    switch (this) {
      case Green:
        return Yellow;
      case Yellow:
        return Red;
      case Red:
        return Green;
    }

    return this;
  }

  public LightColor next(int elapsed) {
    if (elapsed >= this.duration) {
      return next();
    }

    return this;
  }

  public int duration;

  private LightColor(int duration) {
    this.duration = duration;
  }
}
