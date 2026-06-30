# Chain of thought

Q : return how many time repeat 'A' so that 'B' become substring of 'A'. if not possible return -1.

## Idea.


- if B wants to become substring of A then length of A should be greator than or equal to length of B.

- by Math.ceil(length of B / length of A) we can find how many times A should repeat to make B become substring of A.

- if B find in A then fine otherwise repeat A one-more time. 
- now if B find then return that ans else return -1.
- 