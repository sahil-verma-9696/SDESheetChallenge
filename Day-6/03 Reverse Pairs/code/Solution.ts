function reversePairs(nums: number[]): number {
  return optimalSol(nums);
}

function optimalSol(arr: number[]): number {
  let n = arr.length;

  return divide(arr, 0, n - 1);
}

function divide(arr: number[], s: number, e: number): number {
  if (s >= e) return 0;

  let m = s + Math.floor((e - s) / 2);

  let invCount = 0;

  // left
  invCount += divide(arr, s, m);

  // right
  invCount += divide(arr, m + 1, e);

  // conqure by merging
  invCount += conqure(arr, s, m, e);

  return invCount;
}

function conqure(arr: number[], s: number, m: number, e: number): number {
  let ll = m - s + 1;

  let lr = e - m;

  let k = s;

  let left = new Array(ll);
  let right = new Array(lr);

  for (let i = 0; i < ll; i++) left[i] = arr[k++];
  for (let i = 0; i < lr; i++) right[i] = arr[k++];

  return mergeTwoSorted(arr, s, left, ll, right, lr);
}

function mergeTwoSorted(
  target: number[],
  k: number,
  left: number[],
  n: number,
  right: number[],
  m: number,
): number {
  let i = 0;
  let j = 0;

  let invCount = 0;

  let a = 0;
  let b = 0;

  while (a < n) {
    while (b < m && left[a] > right[b] * 2) {
      b++;
    }
    invCount += b;
    a++;
  }

  while (i < n && j < m) {
    if (left[i] < right[j]) target[k++] = left[i++];
    else {
      target[k++] = right[j++];
    }
  }

  while (i < n) target[k++] = left[i++];

  while (j < m) target[k++] = right[j++];

  return invCount;
}
