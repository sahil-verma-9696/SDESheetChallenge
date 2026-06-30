function myAtoi(s: string): number {
  let res = 0;
  let n = s.length;

  const map = {
    "0": 0,
    "1": 1,
    "2": 2,
    "3": 3,
    "4": 4,
    "5": 5,
    "6": 6,
    "7": 7,
    "8": 8,
    "9": 9,
  } as const;

  let isNeg = false;

  let i = 0;

  while (s[i] == " ") i++;

  if (s[i] == "-") {
    isNeg = true;
    i++;
  } else if (s[i] == "+") {
    i++;
  }

  while (i < n) {
    let c = s[i] as keyof typeof map;

    if (map[c] == undefined) break;

    res = res * 10 + map[c];
    i++;
  }

  res = isNeg ? -res : res;
  return clamp32(res);
}

function clamp32(num: number): number {
  const INT_MIN = -(2 ** 31);
  const INT_MAX = 2 ** 31 - 1;

  return Math.max(INT_MIN, Math.min(num, INT_MAX));
}
