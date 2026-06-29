function longestPalindrome(s: string): string {
    let start = 0;
    let end = 1;
    let n = s.length;

    for (let i = 1; i <= n; i++) {
        for (let j = 0; j <= n - i; j++) {
            const s2 = j;
            const e2 = j + i;
            let prevLen = end - start + 1;
            if (isPalindrome(s, s2, e2-1)) {
                let nextLen = e2 - s2 + 1;
                if (nextLen > prevLen) {
                    start = s2;
                    end = e2;
                }
            }
        }
    }

    return s.substring(start, end);
};

function isPalindrome(str: string, s: number, e: number): boolean {
    let res = true;
    while (s <= e) {
        if (str[s] !== str[e]) {
            res = false;
            break;
        };
        s++;
        e--;
    }
    return res;
}