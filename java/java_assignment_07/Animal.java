/*
# Zoo Animal Sound Board

## Objective

Practice defining a class hierarchy using an abstract base class, overriding behavior in multiple subclasses, and 
selecting/instantiating the correct subclass based on user input read in a loop.

## Instructions

- Define an abstract class named `Animal`. This class should declare (at minimum) two abstract methods:
  - `makeSound()` — returns or prints the animal's sound
  - `describe()` — returns or prints a short description specific to that animal
- Create at least three subclasses of `Animal` (for example, `Dog`, `Cat`, `Bird`), each providing its own implementation of `makeSound()` and `describe()`.
- Using `Scanner`, display a number-based menu of the available animals, along with an option to exit. For example:
  ```
  1. Dog
  2. Cat
  3. Bird
  0. Exit
  ```
- In a loop, prompt the user to enter a number corresponding to their selection.
  - If the user selects a valid animal number, instantiate the corresponding subclass and call its `makeSound()` and `describe()` methods to display animal-specific output, then show the menu again for another selection.
  - If the user enters `0`, print a farewell message and end the program.
  - If the user enters a number that does not correspond to any menu option, or a non-numeric value, handle this gracefully with a clear message, and show the menu again rather than crashing.
- Avoid duplicating shared logic across your subclasses where the abstract base class can hold it instead.


*/

package assignments.java.java_assignment_07;

public abstract class Animal {

    public abstract void makeSound();
    public abstract void describe();




       /*  - Define an abstract class named `Animal`. This class should declare (at minimum) two abstract methods:
  - `makeSound()` — returns or prints the animal's sound
  - `describe()` — returns or prints a short description specific to that animal*/

}
