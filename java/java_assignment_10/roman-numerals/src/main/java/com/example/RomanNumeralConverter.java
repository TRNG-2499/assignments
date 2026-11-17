/*

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

- Roman numeral **input** is case-insensitive: `toInteger` should accept `"xiv"`, `"XIV"`, 
and `"Xiv"` equally. Roman numeral **output** from `toRoman` is always uppercase.
- Invalid input should cause an `IllegalArgumentException` to be thrown, with a clear message. 
The provided tests show which inputs are considered invalid.

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

*/
package com.example;
public class RomanNumeralConverter {

    public static String toRoman(int n){

        if(n < 1){
            throw new IllegalArgumentException("Input cannot less than 1.");
        }

        if(n > 3999){
            throw new IllegalArgumentException("Input cannot be greater than 3999");
        }


        String s = "";

        //M, CM, D, CD, C, XC, L,XL, X, IX, V, IV, I

        String[] numerals = {"M", "CM", "D","CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;

        while(n > 0){
            
            if(n >= values[i]){
                s +=(numerals[i]);
                n -= values[i];

            } else{
                i += 1;
            }
        }

        return s;

    }

    public static int toInteger(String s){

    if(s == null || s.isBlank()){
        throw new IllegalArgumentException("Input cannot be null or blank.");
    }

    s = s.toUpperCase(); //case insensitive

    String symbols = "MDCLXVI";
    int[] values = {1000, 500, 100, 50, 10, 5, 1};

    int count = 0;

    // Check for invalid characters
    for(int i = 0; i < s.length(); i++){
        if(!symbols.contains(String.valueOf(s.charAt(i)))){
            throw new IllegalArgumentException("Invalid character.");
        }
    }

    // Convert Roman numeral to integer
    for(int i = 0; i < s.length(); i++){

        int current = values[symbols.indexOf(s.charAt(i))];

        if(i + 1 < s.length()){
            int next = values[symbols.indexOf(s.charAt(i + 1))];

            //if smaller than next, subtract it. ex CM
            if(current < next){
                count -= current;
                continue;
            }
        }
        count += current;
    }

    // Check range
    if(count < 1 || count > 3999){
        throw new IllegalArgumentException("Invalid range.");
    }

    // Convert integer back to Roman numeral to see if it's valid
    String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};

    int[] numeralValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    String expected = "";
    int remaining = count;

    for(int i = 0; i < numerals.length; i++){
        while(remaining >= numeralValues[i]){
            expected += numerals[i];
            remaining -= numeralValues[i];
        }
    }

    if(!s.equals(expected)){
        throw new IllegalArgumentException("Invalid Roman numeral.");
    }

    return count;
}
}
