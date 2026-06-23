# Chain of thought

## Thought 1

using merge 2 sorted list idea. 

complexity analysis


first two list = O(N + N)

then third and result = O( (N + N) + N)

then fourth and result = O( (N + N + N) + N)

....


its become

2N + 3N + 4N + 5N + ... + KN

N * (1 + 2 + 3 + 4 + ... + K)

N * (K * (K + 1) / 2)

O(N*N*N) = O(N^3) near about.


## thought 2 

using min heap idea.

its take 

N * M * log(N*M) 

better than merge 2 sorted list idea.
