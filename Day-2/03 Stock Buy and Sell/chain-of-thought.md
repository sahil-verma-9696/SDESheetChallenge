# 1. Via Observation

traverse from last and store the maximum for each day.

```java
int[] nextMaxs = new int[n];
int max = 0;

for (int i = n - 1; i >= 0; i--) {
    max = Math.max(prices[i], max);
    nextMaxs[i] = max;
}
```


then traverse again and find the maximum profit


```java
int maxProfit = 0;
for (int i = 0; i < n; i++) {
    int dif = nextMaxs[i] - prices[i];
    maxProfit = Math.max(maxProfit, dif);
}
```