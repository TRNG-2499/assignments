# Completed Coding Challenges

## LeetCode

### Java

- **Reverse Integer (#7)** — Reverse the digits of a signed 32-bit integer, keeping its sign. Return zero if the reversed value is outside the 32-bit range.
- **Palindrome Number (#9)** — Determine whether an integer reads the same forward and backward. Negative integers return false.
- **Longest Common Prefix (#14)** — Find the longest starting substring shared by every string in an array. Return an empty string if there is no common prefix.
- **Length of Last Word (#58)** — Return the number of characters in the last word, ignoring trailing spaces.
- **Valid Palindrome (#125)** — Determine whether a string reads the same forward and backward after ignoring case and skipping non-alphanumeric characters.
- **Reverse Words in a String (#151)** — Reverse the order of the words and return them separated by single spaces, with no leading or trailing spaces.
- **Factorial Trailing Zeroes (#172)** — Given a nonnegative integer, return the number of trailing zeroes in its factorial.
- **Number of 1 Bits (#191)** — Count the set bits in a 32-bit integer.
- **Happy Number (#202)** — Repeatedly replace a positive integer with the sum of the squares of its digits. Determine whether the process reaches 1 or enters a cycle.
- **Power of Two (#231)** — Determine whether an integer is a power of two.
- **Valid Anagram (#242)** — Determine whether two lowercase strings contain the same letters with the same frequencies.
- **Add Digits (#258)** — Repeatedly sum the digits of a nonnegative integer until a single digit remains, then return it.
- **First Unique Character in a String (#387)** — Return the zero-based index of the first character that appears once, or `-1` if every character repeats.
- **Is Subsequence (#392)** — Determine whether all characters in one string appear in the same order in another string. Characters in the second string may be skipped.

### Related Java practice

- **Reverse a String** — Return the characters of a string in reverse order without using `StringBuilder.reverse()`. [LeetCode #344](https://leetcode.com/problems/reverse-string/) requires in-place reversal of a character array.
- **Capitalize Each Word** — Uppercase the first letter of each word and lowercase the rest. Assume single spaces between words. [LeetCode #2129](https://leetcode.com/problems/capitalize-the-title/) leaves one- and two-letter words lowercase.
- **String Compression** — Encode each run of consecutive identical characters as the character followed by its count. Return the original string if the result is the same length or longer. [LeetCode #443](https://leetcode.com/problems/string-compression/) compresses in place and returns the new length.
- **Count Words** — Count words in a sentence that may contain extra whitespace. Return zero for blank input. [LeetCode #434](https://leetcode.com/problems/number-of-segments-in-a-string/) counts segments separated by spaces.
- **Word Frequency** — Count how often each word appears in a whitespace-separated string, ignoring case. [LeetCode #192](https://leetcode.com/problems/word-frequency/) uses Bash and sorts by descending frequency.
- **Sum of Digits** — Return the sum of the decimal digits of an integer, ignoring its sign. [LeetCode #3099](https://leetcode.com/problems/harshad-number/) returns the digit sum only when it divides the input.
- **Count Digits** — Return the number of decimal digits in an integer. Ignore the sign and count zero as one digit. [LeetCode #1295](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/) counts array elements with an even digit count.
- **Prime Numbers with Stream API** — Use Java streams to return all prime numbers from 2 through a given upper bound. [LeetCode #204](https://leetcode.com/problems/count-primes/) counts primes strictly below the upper bound.
- **Greatest Common Divisor** — Find the largest positive integer that divides both input integers. [LeetCode #1979](https://leetcode.com/problems/find-greatest-common-divisor-of-array/) uses the minimum and maximum values of an array.
- **FizzBuzz (Single Number)** — Return `FizzBuzz` for a multiple of both 3 and 5, `Fizz` for a multiple of 3, `Buzz` for a multiple of 5, or the number as text. [LeetCode #412](https://leetcode.com/problems/fizz-buzz/) applies the rules to every number from 1 through the input.
- **Armstrong Number** — Determine whether a number equals the sum of its digits each raised to the power of the number of digits. [LeetCode #1134](https://leetcode.com/problems/armstrong-number/) asks for the same check on positive integers.

### PostgreSQL

- **Recyclable and Low Fat Products** — Return the IDs of products marked as both low fat and recyclable.
- **Find Customer Referee** — Return the names of customers whose referee ID differs from 2, including customers with no referee.
- **Article Views I** — Return the distinct IDs of authors who viewed at least one of their own articles, sorted by ID.
- **Invalid Tweets** — Return the IDs of tweets whose content exceeds 15 characters.
- **Product Sales Analysis I** — Return the product name, year, and price for each sale using the sales and product tables.
- **Customer Who Visited but Did Not Make Any Transactions** — For each customer with at least one visit without a transaction, return the customer ID and the number of those visits.
- **Rising Temperature** — Return the IDs of dates with a higher temperature than the previous calendar day.
- **Students and Examinations** — Return every student and subject pair with its exam attendance count, including zero counts. Sort by student ID and subject name.

## HackerRank

### Related Java practice

- **String Palindrome** — Determine whether a string reads the same forward and backward when letter case is ignored. [Java String Reverse](https://www.hackerrank.com/challenges/java-string-reverse/problem) uses lowercase input and prints `Yes` or `No`.
- **Remove Duplicate Characters** — Keep the first occurrence of each character and preserve their order. [String Reductions](https://www.hackerrank.com/challenges/string-reductions/problem) applies the same rule to lowercase letters.
- **Is Prime** — Determine whether an integer greater than 1 is divisible only by 1 and itself. [Time Complexity: Primality](https://www.hackerrank.com/challenges/ctci-big-o/problem) checks multiple inputs.
- **Factorial** — Return the product of the integers from 1 through a given nonnegative integer. The factorial of zero is 1. [Extra Long Factorials](https://www.hackerrank.com/challenges/extra-long-factorials/problem) requires arbitrary precision for larger inputs.
- **Average Test Scores** — Parse space-separated whole-number scores and return their average as a `double`. [Finding the Percentage](https://www.hackerrank.com/challenges/finding-the-percentage/problem) looks up a student by name and prints the average to two decimal places.
- **Longest City Name** — Read a city count followed by that many lines. Return the longest full city name, including spaces within names. [Weather Observation Station 5](https://www.hackerrank.com/challenges/weather-observation-station-5/problem) uses SQL to find both extremes and breaks ties alphabetically.

### PostgreSQL

- **Revising the Select Query I** — Return every column for U.S. cities with a population greater than 100,000.
- **Weather Observation Station 4** — Return the number of city entries minus the number of distinct city names in the station table.
- **Weather Observation Station 5** — Return the shortest and longest city names and their lengths. Break ties by choosing the alphabetically first city.
- **Japan Population** — Return the sum of the populations of all cities with country code `JPN`.
- **Population Density Difference** — Return the difference between the largest and smallest city populations.

## AI-Generated Questions

### Java strings and collections

- **Count Vowels** — Count occurrences of `a`, `e`, `i`, `o`, and `u`, regardless of case.
- **Find All Vowels in a String** — Return every vowel in order, keeping repeats and the original case.
- **Convert an Array into an ArrayList** — Copy an integer array into an `ArrayList` that the caller can add to.

### Java parsing and input

- **Sum a CSV Line** — Parse comma-separated integers and return their sum, allowing spaces around each value.
- **Time to Seconds** — Convert an `HH:MM:SS` value to its total number of seconds.
- **Decode a Secret Message** — Convert dash-separated ASCII codes into characters and return the decoded string.
- **Dollars Only** — Read prices separated by semicolons, discard the cents, and return the whole-dollar amounts separated by commas.
- **Sum Until It's Not a Number** — Read and sum consecutive integers from a `Scanner` until the next token is not an integer or the input ends.
- **Top Scorer** — Read lines containing a name and a comma-separated score, then return the name of the highest scorer.
