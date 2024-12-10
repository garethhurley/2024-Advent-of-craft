# Quick Retro

## What did you learn?

- Baby-steps way to introduce the map configuration
- Additional test cases were necessary before refactoring

## What puzzles do you have?

- Some refactoring suggestions were very aggressive - I have never seen IDE refactoring diverge so far from my intentions
  - Example: I want to extract part of a boolean expression to a method. The aggressive refactoring extracted unselected code to an unwanted method.
    - is this a bug due to the new Intellij?
    - is this a bug due to Copilot?
- io.vavr.collection.LinkedHashMap? I thought vavr was just for test code, not production code?
- FizzBuzz should not be static.  The configuration should be passed into the constructor and not the covert method.
  - Ideally a Builder (or factoring method) would sanity-check the configuration
  - Ideally we should make a copy of the input configuration map, to avoid external mutation