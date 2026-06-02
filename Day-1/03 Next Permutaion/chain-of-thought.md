Observe from `left->right`

Example 1 : 

inp = [ `1, 2,` 3, 4 ]
ans = [ `1, 2,` 4, 3 ]

* i thought. should i swap the `1` with next greatest element `2`.
  But, it is not the answer. 

* i thought. should i swap the `2` with next greatest element `3`.
  But, it is not the answer.    

* i thought. should i swap the `3` with next greatest element `4`.
  Yes. 


* i swap the last two items. if all elements of A are in ascending order.

inp[0] == ans[0]
inp[1] == ans[1] <-- till here every item same
inp[2] != ans[2] <-- here item is differ

---

Example 2 :

inp = [ `1`, 2, 4, 3 ]
ans = [ `1`, 3, 2, 4 ]

* should i swap `1` with `2`. No.
* should i swap `2` with `3`. Yes. <-- it is actually replacing not swapping.
  Why ? 
  Don't figureout yet.

* Next `4` is put in last.
* `2` is shift by `1` to the right.

---

Example 3 :

inp = [ `1`, 3, 2, 4 ]
ans = [ `1`, 3, 4, 2 ]

* both inp[0] and ans[0] are same.
* both inp[1] and ans[1] are same.

* last two get swaped.

---

Example 4 :

inp = [ `1`, 3, 4, 2 ]
ans = [ `1`, 4, 2, 3 ]

---

Example 5 :

inp = [ `1`, 4, 2, 3 ]
ans = [ `1`, 4, 3, 2 ]

---

Example 6 :

inp = [ 1, 4, 3, 2 ]
ans = [ 2, 1, 3, 4 ]

---

Example 7 :

inp = [ 2, 1, 3, 4 ]
ans = [ 2, 1, 4, 3 ]



STOP 

What is the smallest possible number you make by arranging this given numbers.

[ 1, 2, 3, 4 ] <-- that is ascending order of elements.

What is the largest possible number you make by arranging this given numbers.

[ 4, 3, 2, 1 ] <-- that is descending order of elements.



We are actually going toward the descending order.