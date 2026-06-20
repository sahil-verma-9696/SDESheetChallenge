function singleNonDuplicate(nums: number[]): number {
    let n = nums.length;

    let s = 0;
    let e = n - 1;

    let ans = -1;

    while (s <= e) {

        let m = s + Math.floor((e - s) / 2);

        if (nums[m - 1] != nums[m] && nums[m] != nums[m + 1]) {
            ans =  nums[m];
            break;
        } else if (nums[m] == nums[m + 1]) {
            if((m) % 2 == 0){
                s = m + 1;
            }else{
                e = m - 1;
            }
        } else if (nums[m] != nums[m + 1]) {
            if((m+1) % 2 == 0){
                s = m + 1;
            }else{
                e = m - 1;
            }
        }

       

    }

    return ans;
};