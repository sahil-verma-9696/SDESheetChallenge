function uniquePaths(m: number, n: number): number {

    let ans = -1;

    // Recursion
    // ans = recurstion(m-1, n-1);

    // Memoization

    // let dp: number[][] = new Array(m);

    // for (let i = 0; i < m; i++) dp[i] = new Array(n);

    // ans = memoization(m - 1, n - 1, dp);


    // Tabulation

    let dp: number[][] = new Array(m);

    for (let i = 0; i < m; i++) dp[i] = new Array(n);

    ans = tabulation(m,n,dp);


    return ans;
};

function recursion(i: number, j: number) {
    if (i < 0 || j < 0) return 0;

    if (i == 0 && j == 0) return 1;

    let up = recursion(i - 1, j);
    let right = recursion(i, j - 1);

    return up + right;
}

function memoization(i: number, j: number, dp: number[][]) {
    if (i < 0 || j < 0) return 0;

    if (i == 0 && j == 0) return 1;

    const storeAns = dp[i][j];

    if (storeAns != undefined) return storeAns;

    let up = memoization(i - 1, j, dp);
    let right = memoization(i, j - 1, dp);

    dp[i][j] = up + right;


    return up + right;
}

function tabulation(m: number, n: number, dp: number[][]) {

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            if (i < 0 || j < 0){
                dp[i][j] = 0;
                continue;
            }

            if (i == 0 && j == 0) {
                dp[i][j] = 1;
                continue;
            }

            let up = 0;
            let right = 0;

            if(i>0) up = dp[i- 1][j];
            if(j>0) right = dp[i][j-1];

            dp[i][j] = up + right;
        }
    }


    return dp[m-1][n-1];
}