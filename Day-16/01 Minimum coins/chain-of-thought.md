# Greedy approach.

Example 1 : 
-----------

Input :

coins = [1,2,5], amount = 11

Output : 3

11 / 5 = 2 :: 11 - (5*2 = 10) = 1 remaining (2 coins of 5)

1 / 2 = 0 Not possible

1 / 1 = 1 :: 1 - 1 = 0 remaining (1 coin of 1)


2 + 1 = 3 coins.

Example 2 : 
-----------

coins = [9, 6, 5, 3, 1], amount = 11

11 / 9 = 1 :: 11 - (9*1 = 9) = 2 remaining (1 coin of 9)

2 / 6 = 0 Not possible

2 / 5 = 0 Not possible

2 / 3 = 0 Not possible

2 / 1 = 2 :: 2 - (1*2 = 2) = 0 remaining (2 coins of 1)

1 + 2 = 3 coins


## Here Greedy fails. actual ans is 2 coins ( 6 + 5 )

so Explore all coins. 