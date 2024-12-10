# Quick Retro

## What did you learn?

- About fuzzy testing and the Faker library in Java
- The fuzziness helps to distinguish between arbitrary and 'important' inputs for the tests.

## What puzzles do you have?

- Fuzziness adds complexity here and the benefits are unclear to me.
  - I see ore benefit if we were passing in ranges of fuzzy values via parameterized testing
- The RECOMMENDED_AGE attribute and 'addAttribute' is ugly.  Either it should be a class variable with semantics or an arbitrary attribute.  Currently, it behaves as both, with asymmetric getter and setter and poor sanity checking.
- assignToChild() is untested but also unused?
