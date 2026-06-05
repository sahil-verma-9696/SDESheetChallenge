class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i : nums){
            if(count == 0){
                res = i;
            }

            if(res == i){
                count++;
            }else{
                count--;
            }
        }

        return res;
    }
}