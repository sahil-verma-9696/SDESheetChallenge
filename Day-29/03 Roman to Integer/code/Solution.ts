function romanToInt(s: string): number {
  const map = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
  } as const;

  let n = s.length;

  let ans = map[s[n - 1] as keyof typeof map];
  
  let pre = ans;

  for (let i = n - 2; i >= 0; i--) {
    let num = map[s[i] as keyof typeof map];

    if (num < pre) ans -= num;
    else ans += num;

    pre = num;
  }

  return ans;
}
