# Quick Retro

## What did you learn?

- Context matters: who is your colleague?  Level of experience? Level of trust/interaction?
- Code reviews have weaknesses:
  - focus on negatives rather than pointing out positive aspects of the solution
  - the wrong time & place to talk about design
  - comments intended to be helpful can be interpreted as aggressive
  - hard to ask open questions (due to the asynchronous nature of the review)
- Better approach: pairing on the code earlier with your Elf colleague. Converging on working agreements for things like handling nulls or naming.

Links:
- https://williamdurand.fr/2013/06/03/object-calisthenics/
- https://blog.codinghorror.com/the-ten-commandments-of-egoless-programming/
- https://youtu.be/trsDnGh-x4U?si=77WszLj40IKmOMDi
- https://youtu.be/EZkrcFVZsKg?si=7YWzrD_GRHcI-K5G

## What puzzles do you have?

- Is introducing a Task object overkill at this point (i.e. where only the name is used)?
- Stack-like 'completeTask()' could be improved

- Copilot: not clear that it brought any value in this context?
  - generated invalid references (for 'first class collections') 
  - auto-completion was too aggressive with its suggestions (e.g. inserting a retro comment about itself - 'great but not perfect')

Overall a great exercise for groups (more than individuals).  The content ('what') of the review was less important than the 'how'.