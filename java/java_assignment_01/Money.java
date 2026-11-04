public class Money implements Comparable<Money> {
  public Money(String amount) throws NumberFormatException, NegativeMoneyException {
    // split at the decimal
    // at the moment, there must be
    // a decimal.
    String[] s = amount.split("\\.");
    if (s.length != 2) {
      throw new NumberFormatException();
    }

    // insert implicit zero for correct parsing
    // as $1.2 is implicitly the same as $1.20
    if (s[1].length() < 2) {
      s[1] += "0";
    } else if (s[1].length() > 2) {
      throw new NumberFormatException("Too many cents.");
    }

    this(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
  }

  public Money(int dollars, int cents) throws NegativeMoneyException {
    if (dollars < 0 || cents < 0) {
      throw new NegativeMoneyException();
    }

    this.dollars = dollars;
    this.cents = cents;
  }

  // note that this intentionally
  // bypasses the negative amount check
  private Money(int amount) {
    this.dollars = amount / 100;
    this.cents = amount % 100;
  }

  public Money take(Money required) throws InsufficientFundsException {
    // a negative number means this < required
    // as defined by Comparable<T>
    if (compareTo(required) < 0) {
      throw new InsufficientFundsException(this, required);
    }

    return absoluteDifference(required);
  }

  public Money absoluteDifference(Money other) {
    return new Money(Math.abs(getTotal() - other.getTotal()));
  }

  @Override
  public int compareTo(Money other) {
    return Integer.compare(getTotal(), other.getTotal());
  }

  @Override
  public String toString() {
    return String.format("$%d.%02d", dollars, cents);
  }

  private int getTotal() {
    return dollars * 100 + cents;
  }

  private int dollars;
  private int cents;
}
