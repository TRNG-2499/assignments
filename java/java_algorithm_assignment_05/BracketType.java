public enum BracketType {
  Parenthesis,
  Bracket,
  Brace;

  public static BracketType fromCharOpening(char c) {
    switch (c) {
      case '(':
        return Parenthesis;

      case '[':
        return Bracket;

      case '{':
        return Brace;

      default:
        return null;
    }
  }

  public static BracketType fromCharClosing(char c) {
    switch (c) {
      case ')':
        return Parenthesis;

      case ']':
        return Bracket;

      case '}':
        return Brace;

      default:
        return null;
    }
  }
}
