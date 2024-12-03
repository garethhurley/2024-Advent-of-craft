# Quick Retro

## What did you learn?

- Extract Parameter Object
- Changing parameters to instance variables in baby-steps

## What puzzles do you have?

- Extract Parameter Object to existing object ... beware of variable naming (need to align names first)
- Prefer my Builder rather than a Configuration parameter object (sorry!)
  - Builder is restricted to the scope of building SantaCommunicators (SRP)
  - Builder's inputs could be validated for 'free' in the `build()` method (e.g. non-negative value for days to rest)
  - Configuration object _moves_ the argument inversion problem to a new class, rather than solving it?
- Should we move the logger to the Communicator?  Feels like a configuration parameter.