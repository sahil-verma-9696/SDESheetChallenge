function threeSum(nums: number[]): number[][] {
    let n = nums.length;

    let res = [];

    let aim = 0;

    nums.sort((a,b)=>a-b);

    for(let i=0; i<n; i++){
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        
        let a = nums[i]

        let l = i+1;
        let r = n-1;

        let tempAim = aim - a;

        

        while(l<r){
            let b = nums[l];
            let c = nums[r];
            
            if(b+c < tempAim){
                l++;
            }else if(b+c > tempAim){
                r--;
            }else{
                res.push([a,b,c]);
                l++;
                r--;

                while(l<r && nums[l] == nums[l-1]) l++;
                while(l<r && nums[r] == nums[r+1]) r--;
            }
        }
    }

    return res
};