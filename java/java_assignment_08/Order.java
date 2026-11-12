package assignments.java.java_assignment_08;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Order {

    private final String itemName;
    private final int quantity;
    private final int stock;
    private final float paymentAmount;
    private final float costAmount;
    private final boolean isExpired;
}