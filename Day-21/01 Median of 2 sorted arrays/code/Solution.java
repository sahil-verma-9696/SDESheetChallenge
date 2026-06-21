class Solution {

    /**
    Optimal Approach 
    ----------------

    Binary Search

    time : O(log(min(m, n)))
    space : O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double ans = 0;

        if(nums1.length <= nums2.length){
            ans = binarySearch(nums1, nums2);
        }else{
            ans = binarySearch(nums2, nums1);
        }
        
        return ans;
    }

    // nums1.length <= nums2.length
    public double binarySearch(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

        /**
        if m + n : 7
            7 + 1 / 2 = 4
        if m + n : 8
            8 + 1 / 2 = 4
         */
        int leftLen = (m + n + 1)/2;


        int s = 0; 
        int e = n;

        while( s <= e ){

            int mid = s + (e - s)/2; // partition from smallest array

            int Py = leftLen - mid; // partition index of second array
            
            // nums1 partition element
            int X1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            int X2 = (mid == n) ? Integer.MAX_VALUE : nums1[mid];

            // nums2 partition elements
            int X3 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py-1];
            int X4 = (Py == m) ? Integer.MAX_VALUE : nums2[Py];


            if( X1 <= X4 && X3 <= X2){

                if((m+n)%2 == 1){
                    return (double)Math.max(X1, X3);
                }else{

                    return ((double)Math.max(X1, X3) + (double)Math.min(X2,X4))/2;
                }

            }


            if(X1 > X4){
                e = mid - 1;
            }else{
                s = mid + 1;
            }

        }

        return -1d;
    }
}