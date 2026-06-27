# Chain of thoght

heights = [2,1,5,6,2,3]


for large reactangle area the bar need to expand more.

bar expand left and right till they meet with next smaller bar.

heights = [ 2,  1, 5, 6,  2,  3]
nxtSmal = [ 1, -1, 2, 2, -1, -1]
bfrSmal = [-1, -1, 1, 5,  1,  2]
         
         b   n
bar[0] : [-1, 1] : 1 - -1 -1 = 1
bar[1] : [-1, n] ; 6 - -1  -1 = 5
bar[2] : [1, 4] : 4 - 1 - 1 = 2
bar[3] : [2, 4] : 4 - 2 - 1 = 1
bar[4] : [1, 6] : 6 - 1 - 1 = 4
bar[5] : [4, 6] : 6 - 4 - 1 = 1