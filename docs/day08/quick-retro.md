# Quick Retro

## What did you learn?

- Tell, don't Ask principle
- Added missing coverage using mocking.  For me, this is a valid scenario to apply mocking.
- Copilot:
  - failed to detect the performance regression, even when prompted to write a test to cover it
  - did generate a valid test using mocking for the performance regression

## What puzzles do you have?

- Solution offered is not strictly correct, since it results in unnecessary save operations.
- My solution avoids the 'save' performance regression but breaks the 'Command-Query Separation' principle by modifying state _and_ returning a value.
  - I believe that violating the CQS principle is a lesser evil than the performance regression.
- Refactoring the findByName method to return an Optional is a good idea, but (1) it is not strictly necessary for the exercise (2) has a significant impact on the implementation.