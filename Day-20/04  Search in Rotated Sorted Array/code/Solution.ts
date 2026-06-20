function search(nums: number[], target: number): number {
    let n = nums.length;

    let s = 0;
    let e = n - 1;

    let ans = -1;

    while(s <= e){
        let m = s + Math.floor((e - s)/2);

        if(nums[m]==target)return m;
        else if(nums[m] < nums[s]){
            // left sorted part
            if(nums[m] <= target && target <= nums[e]){
                s = m + 1;
            }else{
                e = m - 1;
            }
        }else{
            // right sorted part
            if(nums[s] <= target && target <= nums[m]){
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
    }
    return -1;
};