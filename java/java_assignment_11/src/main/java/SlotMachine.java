import java.util.Random;

class SlotMachine extends Entity {
    private static final String[] SUITS = {"Spades", "Diamonds", "Clubs", "Hearts"};
    private final Random rand = new Random();

    public SlotMachine() {
        super("SlotMachine", "A compact and convenient slot machine suitable for at-home use", "");
    }

    private String spin() {
        return SUITS[rand.nextInt(SUITS.length)];
    }

    @Override
    public String interact() {
        String a = spin(), b = spin(), c = spin();
        String result = "You pull the lever... || " + a + " || " + b + " || " + c + " ||";
        if (a.equals(b) && b.equals(c)) {
            result += " JACKPOT!";
        }
        return result;
    }
}
