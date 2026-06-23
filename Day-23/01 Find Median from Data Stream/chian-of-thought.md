# Chain of thought

## Thought 1

I take a minHeap and a lst.
got TLE

```java
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    List<Integer> lst;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        lst = new ArrayList<>();
    }

    public void addNum(int num) {
        minHeap.offer(num);
    }

    public double findMedian() {
        int size = minHeap.size();
        int mid = size / 2;

        if (size % 2 == 0) {
            while(mid-- >= 0 && !minHeap.isEmpty()){
                lst.add(minHeap.poll());
            }

            double a = (double)lst.get(lst.size()-1);
            double b = (double)lst.get(lst.size()-2);


            while(!lst.isEmpty()){
                minHeap.offer(lst.remove(lst.size() - 1));
            }

            return (a + b)/2;
        } else {

            while(mid-- >= 0 && !minHeap.isEmpty()){
                lst.add(minHeap.poll());
            }

            double ans = (double)lst.get(lst.size()-1);

            while(!lst.isEmpty()){
                minHeap.offer(lst.remove(lst.size() - 1));
            }

            return ans;
        }

    }
}

```

### Why got TLE

#### Constraints

* `-10^5 <= num <= 10^5`
* At most `10^5` calls will be made to `addNum` and `findMedian`


## Thought 2
