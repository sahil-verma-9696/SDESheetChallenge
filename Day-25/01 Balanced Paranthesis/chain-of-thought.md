# Chain of Thought

## Balanced Paranthesis

- the most recently opened parenthesis is closed by the next closing parenthesis.

### Example

"("  

### Balanced Paranthesis Rules

- it is expected that next `closing parenthesis` is ")".
- Or there is **any other** `opening parenthesis` is `ACCEPTABLE`.
- Any other `closing parenthesis` is `NOT ACCEPTABLE`.
- Always **start** from `opening parenthesis`.
- **equal number** of `opening` and `closing` parenthesis.

## Invalid Examples

- "]"
- "(})"
- "()("


# Why Stack Data Structure.

It helps to track the recently Used item.