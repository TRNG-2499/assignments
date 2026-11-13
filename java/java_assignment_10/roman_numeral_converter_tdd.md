# Roman Numeral Converter (TDD)

## Objective

Practice test-driven development (TDD) with JUnit 5: reading a test suite as a specification, working through failing tests one at a time, and writing code that satisfies a complete set of tests.

## Instructions

- You will be provided with a complete JUnit 5 (Jupiter) test class named `RomanNumeralConverterTest`. **Do not modify or remove any of the provided tests.** Your job is to write the code that makes every one of them pass.
- Create a class named `RomanNumeralConverter` containing two `static` methods:
  - `toRoman(int number)` — converts an integer to a Roman numeral `String`
  - `toInteger(String roman)` — converts a Roman numeral `String` to an `int`
- Your project may be set up with either Maven or Gradle. You will need the `junit-jupiter` dependency.
- Valid numbers range from `1` to `3999`.
- Roman numerals are built from the following seven letters:

  | Letter | Value |
  |---|---|
  | `I` | 1 |
  | `V` | 5 |
  | `X` | 10 |
  | `L` | 50 |
  | `C` | 100 |
  | `D` | 500 |
  | `M` | 1000 |

- Roman numeral **input** is case-insensitive: `toInteger` should accept `"xiv"`, `"XIV"`, and `"Xiv"` equally. Roman numeral **output** from `toRoman` is always uppercase.
- Invalid input should cause an `IllegalArgumentException` to be thrown, with a clear message. The provided tests show which inputs are considered invalid.
- You may not use any library or built-in feature that performs Roman numeral conversion for you.
- The provided test suite is organized into groups that progress from easy to hard, so you can build your solution up gradually. Work in the TDD rhythm:
  1. **Red** — run the suite and pick a single failing test
  2. **Green** — write the simplest code that makes that test pass
  3. **Refactor** — once the tests are passing, clean up your code without breaking any tests

  Avoid trying to write the whole solution before running the tests.
- As you work, take a personal note of which test group took you the longest, and how the TDD rhythm helped or hindered your progress. This is for your own reflection only, and is not a deliverable — consider how this approach compares with how you would normally approach a problem without a test suite to guide you.

## Example Interactions

**Conversions**
```
toRoman(4)         -> "IV"
toRoman(1994)      -> "MCMXCIV"
toRoman(3999)      -> "MMMCMXCIX"
toInteger("XLII")  -> 42
toInteger("mcmxciv") -> 1994
```

**Invalid input**
```
toRoman(0)         -> throws IllegalArgumentException
toRoman(4000)      -> throws IllegalArgumentException
toInteger("ABC")   -> throws IllegalArgumentException
toInteger("")      -> throws IllegalArgumentException
toInteger(null)    -> throws IllegalArgumentException
```

**Test runs**
```
First run (before any code is written):
    Tests run: N, Failures: N

Final run:
    Tests run: N, Failures: 0
```

## Requirements Checklist

- [ ] A class named exactly `RomanNumeralConverter` exists, in a file named exactly `RomanNumeralConverter.java`
- [ ] The class contains `static` methods `toRoman(int)` and `toInteger(String)`
- [ ] Every test in the provided `RomanNumeralConverterTest` class passes
- [ ] The provided test class has not been modified
- [ ] `toRoman` always returns uppercase output
- [ ] `toInteger` accepts uppercase, lowercase, and mixed-case input
- [ ] Out-of-range numbers, `null`, empty strings, and non-numeral characters throw an `IllegalArgumentException` with a clear message
- [ ] No library or built-in feature is used to perform the conversion
- [ ] Code has been refactored and is clean and readable

## Stretch Goals

For each stretch goal, write your tests in a **new test file** (for example, `RomanNumeralStrictValidationTest`) or in a new **`@Nested` class** of your own. Do not change any of the provided tests, which must continue to pass.

- **Strict Validation** — Update `toInteger` so that it rejects non-standard Roman numerals, throwing an `IllegalArgumentException`. For example, `"IIII"`, `"VV"`, `"IC"`, and `"VX"` are not valid numerals, even though a simple conversion could read a value from them. Write your own tests for these cases *before* changing your code.
- **Write Tests First** — Add a `static` method `add(String a, String b)` that adds two Roman numerals and returns the result as an uppercase Roman numeral. It should throw an `IllegalArgumentException` if either input is invalid, or if the sum is greater than `3999`. Practice true TDD: write your tests for this method *first*, run them to see them fail, and only then write the code to make them pass.
