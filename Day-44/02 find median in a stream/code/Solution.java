class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        // all greator elements dump into minHeap
        minHeap = new PriorityQueue<>();

        // all smaller elements dump into maxHeap
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance heaps
        if (maxHeap.size() - minHeap.size() > 1) { // 
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();

        if (size % 2 == 0) {
            double a = (double) maxHeap.peek();
            double b = (double) minHeap.peek();

            return (a + b) / 2;
        } else {
            double ans = (double) maxHeap.peek();

            return ans;
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */