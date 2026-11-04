//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class vending_GP {
    public static void main(String[] args) {

        //Made these to test my method!
        System.out.println("1");
        System.out.println(vending(1.0, 2.0));
        System.out.println("2");
        System.out.println(vending(3.0, 2.0));
        System.out.println("3");
        System.out.println(vending(-1.0, 2.0));

    }

    public static String vending(double price, double money) {
        if (price < 0 || money < 0) {
            return "Invalid input, negative numbers are not allowed";
        }
        if (money < price) {
            return "Insufficient funds, please insert " + (price - money) + " more dollars";
        }

        if (price <= money) {
            return "item dispensed, you have " + (price - money) + " in change";
        }
        return "";
    }

}