public class java_assignment_01_solution {

    // Vending Machine
    public static void main(String[] args) {

        String a = Input(2.00, 2.00); // Success
        System.out.println(a);

        String b = Input(-1, 2);// Invalid item price
        System.out.println(b);

        String c = Input(2.00, -1);// Invalid amount
        System.out.println(c);

        String d = Input(2.00, 1.00);// Insufficient
        System.out.println(d);

    }

    public static String Input(double a, double b) {
        String Inputs = String.format("Price: %.2f, amountInserted: %.2f", a, b);
        System.out.println(Inputs);

        if (a < 0) { // Invalid price
            return "Invalid input, item cannot be negative.";
        } else if (b < 0) { // Invalid amount
            return "Invalid input, amount inserted cannot be negative.";
        } else { // Valid transaction

            if (a <= b) { // Balance > price

                String result = String.format("Purchase was successful. Change due: %.2f", b - a);
                return result;
            } else { // Balance < price
                String result = String.format("Insufficient funds, please insert %.2f more", a - b);
                return result;
            }
        }
    }
}
