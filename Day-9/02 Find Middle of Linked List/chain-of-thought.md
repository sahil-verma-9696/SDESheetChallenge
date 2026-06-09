# Find Middle

# Ideas

1. Two pointers, one moves twice as fast as the other.

1 -> 2 -> 3 -> 4 -> null
h
i    
j

`i = i.next`
`j = j.next.next`

1 -> 2 -> 3 -> 4 -> null
h
     i    
         j

            STOP


## Example 2

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
h
i
j

`i = i.next`
`j = j.next.next`

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
h 
     i
          j


`i = i.next`
`j = j.next.next`

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
h 
          i
                    j
        

`i = i.next`
`j = j.next.next`

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
h
               i
                              j

`i = i.next`
`j = j.next.next`

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
h
                    i
                                        j

                    STOP

j.next == null ? i : i.next

j is fast pointer
i is slow pointer