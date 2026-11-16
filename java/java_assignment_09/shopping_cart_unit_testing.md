# Shopping Cart Unit Testing

## Objective

Practice writing JUnit 5 unit tests that validate an existing class, covering normal behavior, edge cases, and exception handling, and using tests to discover incorrect logic.

## Instructions

- You will be provided with a `ShoppingCart` class. **Do not modify it.** Your job is to write a JUnit 5 (Jupiter) test class named `ShoppingCartTest` that validates its behavior.
- Your project may be set up with either Maven or Gradle. You will need the `junit-jupiter` dependency.
- The `ShoppingCart` class provides the following public methods:
  - `addItem(String name, double price, int quantity)` — adds an item to the cart. If an item with the same name (matched exactly, including casing) is already in the cart, its quantity is increased instead. Throws an `IllegalArgumentException` if the name is `null` or blank, the price is negative, or the quantity is less than 1.
  - `removeItem(String name)` — removes the item with the given name from the cart entirely, returning `true` if the item was in the cart and `false` otherwise.
  - `getItemCount()` — returns the total quantity of all items in the cart.
  - `getSubtotal()` — returns the sum of price multiplied by quantity for every item in the cart, before any discount. An empty cart has a subtotal of `0.0`.
  - `applyDiscountCode(String code)` — applies a percentage discount to the cart. Only one discount can be active at a time; applying a new valid code replaces any previously applied code. Throws an `IllegalArgumentException` if the code is `null` or is not one of the valid discount codes listed below. Codes are case-sensitive.
  - `getTotal()` — returns the subtotal with the currently applied discount (if any) taken off. If no discount has been applied, it returns the subtotal. No rounding is applied.
  - `isEmpty()` — returns whether the cart contains no items. (You are **not** required to test this method.)
- The valid discount codes are available as constants in the `ShoppingCart` class:

  | Constant | Code | Discount |
  |---|---|---|
  | `ShoppingCart.CODE_SAVE10` | `"SAVE10"` | 10% off |
  | `ShoppingCart.CODE_SAVE20` | `"SAVE20"` | 20% off |
  | `ShoppingCart.CODE_HALF_OFF` | `"HALFOFF"` | 50% off |

  Any other string (including a valid code with different casing) is considered invalid.
- Write **at least three unit tests per method** for each of the following six methods: `addItem`, `removeItem`, `getItemCount`, `getSubtotal`, `applyDiscountCode`, and `getTotal`. Across each method's tests, cover a mix of:
  - Typical, expected usage
  - Edge cases (such as an empty cart, boundary values, or repeated calls)
  - Invalid input, using `assertThrows` where an exception is expected
- Each test should start from a fresh `ShoppingCart` (for example, by using `@BeforeEach`), and tests must not depend on each other or on the order they run in.
- Give each test a name that clearly describes the scenario being tested and the expected outcome.
- When comparing `double` values, use the version of `assertEquals` that accepts a delta.
- **Note:** at least one method in the provided `ShoppingCart` class contains incorrect logic. Do not assume the code behaves as described above — your tests should be thorough enough to catch the problem. Which method is incorrect is not revealed.
- Run your tests. You are **not** asked to fix the incorrect method — only to identify it. Add a code comment at the top of your `ShoppingCartTest` class that names the method you believe contains the incorrect logic, lists the test(s) that failed because of it, and explains in a sentence or two what the method does wrong.

## Example Interactions

A sample test for a method that you are not required to test, shown for reference. Notice the **Arrange / Act / Assert** structure, which is a useful pattern for organizing any unit test:

```java
@Test
void isEmpty_newCart_returnsTrue() {
    // Arrange: set up the objects and data the test needs.
    //          Here, we create a brand-new cart with nothing in it.
    ShoppingCart cart = new ShoppingCart();

    // Act: perform the single action being tested.
    //      Keep this to one call to the method under test.
    boolean result = cart.isEmpty();

    // Assert: verify the outcome is what you expect.
    //         A test should fail clearly if the behavior is wrong.
    assertTrue(result);
}
```

## Requirements Checklist

- [ ] A `ShoppingCartTest` class exists and uses JUnit 5 (Jupiter)
- [ ] The provided `ShoppingCart` class has not been modified
- [ ] At least three tests are written for each of `addItem`, `removeItem`, `getItemCount`, `getSubtotal`, `applyDiscountCode`, and `getTotal` (18 or more tests total)
- [ ] Tests cover typical usage, edge cases, and invalid input across the methods
- [ ] `assertThrows` is used to verify the expected exceptions
- [ ] Each test starts from a fresh cart, and tests do not depend on one another or on execution order
- [ ] Test names clearly describe the scenario and expected outcome
- [ ] `double` comparisons use a delta
- [ ] Tests follow a clear Arrange / Act / Assert structure
- [ ] A code comment at the top of `ShoppingCartTest` identifies the method containing incorrect logic, the failing test(s), and what the method does wrong
- [ ] The incorrect method has been identified only — it has not been fixed

## Stretch Goals

Write these in addition to your original tests — do not replace the tests you have already written.

- **Parameterized Tests** — Use `@ParameterizedTest` (with `@CsvSource`, `@ValueSource`, or similar) to test several inputs from a single test method. For example, verify that every valid discount code produces the expected total, or that a variety of invalid codes and invalid `addItem` inputs all throw an `IllegalArgumentException`.
- **Grouped Assertions** — Use `assertAll` to write at least two tests that verify several related conditions at once (for example, checking both the item count and the subtotal after adding several items), so that all failures are reported together instead of stopping at the first failed assertion.
