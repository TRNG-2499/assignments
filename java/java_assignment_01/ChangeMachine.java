import java.util.Scanner;

public class ChangeMachine {
    public static void main(String[] args) {
        //ChangeMachine machine = new ChangeMachine();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Make selection, 1 for Single Item, 2 for Multiple Items: ");
        int sel = scanner.nextInt();
        double change;
        switch (sel) {
            case 1 -> {
                System.out.print("Price: $");
                double price = scanner.nextDouble();

                System.out.print("Insert Cash: $");
                double cash = scanner.nextDouble();

                change = MakeChange(price, cash);

                if (change < 0)
                    return;
            }
            case 2 -> {
                System.out.print("Number of Items: ");
                int size = scanner.nextInt();

                System.out.println("Enter " + size + " prices:");
                double[] priceList = new double[size];

                for (int i = 0; i < size; i++) {
                    priceList[i] = scanner.nextDouble();
                }
                    
                System.out.print("Insert Cash: $");
                double cash = scanner.nextDouble();

                change = MultiPurchase(priceList, cash);
                if (change < 0)
                    return;
            }
            default -> {
                System.out.println("Invalid Selection Made, exiting");
                return;
            }
        }
        scanner.nextLine();
        System.out.print("Denominate? (y/n): ");
        String bool = scanner.nextLine();
        if (bool.equalsIgnoreCase("y")) {
            Denominate(change);
        }

        
    }

    public static double MakeChange(double price, double amountInserted) {
        if (price < 0){
            System.out.println("Invalid input: please input non-negative price");
            return -1;
        }
        else if (amountInserted < 0){
            System.out.println("Invalid input: please insert non-negative cash amount");
            return -1;
        }
        
        double change = amountInserted - price;
        if (change == 0)
            System.out.println("Purchase Successful. No change due");
        else if (change > 0)
            System.out.println("Purchase Successful. Change due: $" + change);
        else
            System.out.println("Insufficient funds, please insert $" + Math.abs(change) + " more");
        return change;
        
    }

    public static double MultiPurchase(double[] priceList, double amountInserted) {
        if (amountInserted < 0){
            System.out.println("Invalid input: please insert non-negative cash amount");
            return -1;
        }
        double runningTotal = 0;
        for (double price : priceList) {
            if (price < 0) {
                System.out.println("Invalid input: please insert non-negative price amounts");
                return -1;
            }

            runningTotal += price;
        }

        return MakeChange(runningTotal, amountInserted);
    }

    public static void Denominate(double change) {
        int[] denoms = new int[]{100, 25, 10, 5, 1};
        int left = (int) (change * 100.0);
        int cnt;
        for (int d : denoms) {
            cnt = left / d;
            left %= d;
            System.out.print(cnt + " * $" + d/100.0 + ", ");
        }

        System.out.println("Total: $" + change);
    }
}