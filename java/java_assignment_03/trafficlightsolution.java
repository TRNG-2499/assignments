public static String colorAfterTicksNoLoop(String startColor, int ticks) {
    int index;
    switch (startColor == null ? "" : startColor) {
        case "Green":  index = 0; break;
        case "Yellow": index = 1; break;
        case "Red":    index = 2; break;
        default:
            return "Invalid input: '" + startColor + "is' not a light color";
    }
    if (ticks < 0) {
        return "neg tick does not work";
    }

    String[] cycle = {"Green", "Yellow", "Red"};
    return cycle[(index + ticks) % 3];
}

void main() {
    System.out.println(colorAfterTicksNoLoop("Green", 1));  // Yellow
    System.out.println(colorAfterTicksNoLoop("Green", 3));  // Green
    System.out.println(colorAfterTicksNoLoop("Red", 5));    // Yellow
    System.out.println(colorAfterTicksNoLoop("Green", 0));  // Green
    System.out.println(colorAfterTicksNoLoop("Purple", 2));
}