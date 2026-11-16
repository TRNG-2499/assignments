# Personal Note — Roman Numeral Converter (TDD)

For my own reflection; not a deliverable.

## How the work was actually done

This solution was written with Claude Code, and the whole of `RomanNumeralConverter` was
written before the first test run rather than one failing test at a time. The suite passed
on the first run (118 provided tests, plus 56 stretch tests), so there was no real
red/green cycle to observe. The notes below are about where the thinking went, not about
time spent stuck on a red bar.

## Which test group took the longest

**Group 3 (subtractive numerals)** is where the design was decided. Groups 1 and 2 can be
passed with a plain seven-letter table and addition. Group 3 is the first one that breaks
that approach, and it forces a different idea in each direction:

- `toRoman`: treat the six subtractive pairs (`CM`, `CD`, `XC`, `XL`, `IX`, `IV`) as
  symbols in their own right, in a 13-entry table ordered largest to smallest, and take
  the largest piece that fits until nothing is left.
- `toInteger`: read left to right and subtract a letter when the letter after it is larger.

Once Group 3 was handled, Groups 4, 5 and 6 needed no new code beyond an uppercase
conversion. Group 7 (invalid input) was the second most involved, mostly because of
`"   "` and `"X I"`: the input is deliberately not trimmed, so whitespace is rejected as
an invalid character like any other.

Of the stretch goals, **strict validation** needed the most thought. Writing a rule for
each kind of bad numeral (`IIII`, `VV`, `IC`, `VX`, `IXI`, ...) gets long quickly. The
shorter route: every number has exactly one standard spelling, so a numeral is valid only
if `toRoman(toInteger(x))` gives back `x`. That is one comparison instead of a rulebook.

## How the TDD rhythm helped or hindered

- **Helped:** the test file reads as a specification. The group order (single symbols,
  additive, subtractive, large, case, round trips, invalid) is the same order in which the
  solution grows, and the round-trip test over all 3999 values gives a lot of confidence
  for very little test code. It also made the strict-validation refactor safe: the
  provided tests kept passing while `toInteger` got stricter.
- **Hindered / skipped:** strict one-test-at-a-time work would have meant writing a
  seven-letter lookup for Groups 1 and 2 and then replacing it in Group 3. Reading the
  whole suite first skipped that throwaway step, at the cost of never seeing the tests
  fail, which is the part of TDD that proves the tests can catch a mistake.
- **Compared with no test suite:** without it, the edge cases in Group 7 (`null`, blank,
  `Integer.MIN_VALUE`, embedded spaces) are the ones most likely to be forgotten. Having
  them listed up front meant they shaped the design instead of being patched in later.

## To try next time

Do the `add` stretch goal by hand in real red/green order: write one test, watch it fail,
make it pass, repeat. That is the part of the exercise this run did not practise.
