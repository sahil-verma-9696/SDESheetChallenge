Very interesting problem.

Prerequisites:

* solve sort 0s and 1s.

---

if  0 <= arr.length <= 10^9 and
arr[i] is { any single integer }.

then no need to sort the array.

---

if arr[i] is { any two integer }.

then 

{ a, a, a, b, b, b, b}

then a < b

all the a's should be left or begining of the array.
and the b's should be right or end of the array.

to do this we only need two pointers left and right. 

then simple 
    left pointer represent the a's position so 
        if arr[left] != a 
        then wait till `right` pointer find `a` element.
        
    as soon as `right` pointer find `a` element.
    then the elements of `left` pointer `right` pointer should swaped.

    since we swaped the `left` pointer element with `right` pointer element.

    left++
    right--

    why ? because they are processed already. and we place elements at right position.


-------------------------------------------------

Now extend this thought for a, b, and c.

`a < b < c`

* left pointer for `a` and right pointer for `c`.

* right pointer for `b` and reference for `a` and `c`.

left = 0;
mid = 0;
right = n - 1;

while(mid <= right)
    if arr[mid] == a: 
        swap(arr, left, mid)
        left++
        mid++
    else if arr[mid] == b:
        mid++
    else if arr[mid] == c:
        swap(arr, mid, right)
        right--
        mid++



Important Case :

[1,2,0]


---------------------------------------------------

Dry run 

a = [1, 2, 0]                    l  m  r
     0, 1, 2                     0  0  2
     l     r                     0  1  2
     m                           0  2  1

a[m] == 1 : true
    m++

a = [1, 2, 0]                    
     0, 1, 2                     
     l     r                     
        m

-------------------------------------------

a[m] == 2 : true
    swap(a, r, m)
    r--
    m++

a = [1, 0, 2]                    
     0, 1, 2                     
     l  r                     
           m

-------------------------------------------


after this dry run 

left = 0;
mid = 0;
right = n - 1;

while(mid <= right)
    if arr[mid] == a: 
        swap(arr, left, mid)
        left++
        mid++
    else if arr[mid] == b:
        mid++
    else if arr[mid] == c:
        swap(arr, mid, right)
        right--
               <----- removed mid++