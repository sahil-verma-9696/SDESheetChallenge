# Revese a Linked List

1 -> 2 -> 3 -> 4 -> 5 -> null

null <- 1 <- 2 <- 3 <- 4 <- 5


# Ideas

1. Create a list in reverse.
2. In place by changing the links.
3. Recursion.


## In-place

P1 = null
P2 = head.next

null   1   -> 2 -> 3 -> 4 -> 5 -> null
P1    head    P2

`head.next = P1`

null <- 1    2 -> 3 -> 4 -> 5 -> null
P1    head   P2

`P1 = head`
`head = P2`
`P2 = P2.next`

null <- 1    2 -> 3 -> 4 -> 5 -> null
       P1   head  P2

`head.next = P1`

null <- 1   <-  2    3 -> 4 -> 5 -> null
        P1    head   P2

`P1 = head`
`head = P2`
`P2 = P2.next`

null <- 1  <-  2      3 -> 4 -> 5 -> null
               P1   head   P2

`head.next = P1`

null <- 1  <-  2  <-   3     4 -> 5 -> null
               P1     head   P2

`P1 = head`
`head = P2`
`P2 = P2.next`

null <- 1  <-  2  <-  3     4 -> 5 -> null
                      P1  head   P2

`head.next = P1`

null <- 1  <-  2  <-  3  <-  4    5 -> null
                      P1   head   P2

`P1 = head`
`head = P2`
`P2 = P2.next`

null <- 1  <-  2  <-  3  <-  4      5 -> null
                             P1   head   P2

`head.next = P1`

null <- 1  <-  2  <-  3  <-  4  <-  5    null
                             P1    head   P2


STOP when P2 is null


