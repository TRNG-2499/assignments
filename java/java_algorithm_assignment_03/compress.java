/*# Compress Consecutive Characters

## Objective

Practice iterating through a string while comparing adjacent characters, tracking a running count, and building a new string incrementally based on that tracking.

## Instructions

- Write a method that accepts a single parameter: a `String`.
- The method should return a new `String` where runs of consecutive, identical characters are replaced with the character followed by the count of how many times it repeated in that run (for example, `"aaabbbccd"` becomes `"a3b3c2d1"`).
- A character that does not repeat (a run of length 1) should still be followed by a `1` in the output, as shown in the example.
- Runs should be identified **case-insensitively** — for example, `"aA"` should be treated as a single run of length 2, not two separate runs. The character used in the compressed output for a given run should match the casing of the **first** character in that run (for example, `"aA"` compresses to `"a2"`, while `"Aa"` compresses to `"A2"`).
- Consider how your method should handle an empty string as input.

## Example Interactions

**Example 1**
```
Input: "aaabbbccd"
Output: "a3b3c2d1"
```

**Example 2 — No repeats**
```
Input: "abcd"
Output: "a1b1c1d1"
```

**Example 3 — Entire string is one run**
```
Input: "aaaaaa"
Output: "a6"
```

**Example 4 — Case-insensitive run, output keeps first character's casing**
```
Input: "aAaA"
Output: "a4"
```

**Example 5 — Empty string**
```
Input: ""
Output: ""
```

## Requirements Checklist

- [ ] Method accepts the string as a parameter (not hardcoded)
- [ ] Correctly identifies runs of consecutive identical characters
- [ ] Runs are identified case-insensitively (e.g., `"aA"` counts as one run)
- [ ] The character used in the output for each run matches the casing of that run's first character
- [ ] Correctly appends the character followed by its run count for every run, including runs of length 1
- [ ] Empty string input is handled without crashing, and returns an empty string
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)*/


package assignments.java.java_algorithm_assignment_03;

import java.util.Scanner;

public class compress {

public static void main(String args[]){

    Scanner myObj = new Scanner(System.in);
    String input = "";

    System.out.println("Insert string");

    while(true){

        System.out.println("Insert string");
        input = myObj.nextLine();

        if(input.equals("exit")){
            break;
        }

        System.out.println(compress_string(input));

    }

    myObj.close();

}

public static String compress_string(String s){

    if(s.length() < 1){
        return s;
    }

    String s2 = "";
    int count = 1;
    char prev = s.charAt(0);
    char current = s.charAt(0);

    for(int i = 1; i < s.length(); i++){

        //Compare to the previous, increment each time. So we can set a flag. Reset and finalize that count once we don't have that, and cont.
        //So previous set to s[0]. OR. We can flag when previous isn't equal to the current. 

        current = s.charAt(i);

        if(Character.toLowerCase(current) != Character.toLowerCase(prev)){
            s2 += Character.toString(prev);
            s2 += Integer.toString(count);
            prev = current; //Only change prev when it's a new unique char
            count = 1; //Reset count
        }
        else{
            count += 1;
        }
        //What about the end?
    }
        s2 += Character.toString(current);
        s2+= Integer.toString(count);


    return s2;

}

}
