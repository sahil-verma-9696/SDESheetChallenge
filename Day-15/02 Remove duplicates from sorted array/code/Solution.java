class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;

        int p1 = 0;


        for(int i = 1; i<n; i++){
            if(nums[p1] != nums[i]){
                p1++;
                nums[p1] = nums[i];
            }
        }


        return p1 + 1;

    }
}


// hasing solution
    // 1. iterate over array
    // 2. for each element check wheter it is map or not
    // 3. if element is not in map 
    // 4. so put the element in map and place that element extream left of the array.

// convert the array into set. 