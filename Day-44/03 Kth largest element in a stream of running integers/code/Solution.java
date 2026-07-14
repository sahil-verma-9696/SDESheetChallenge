class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b - a);

    Integer k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int n : nums){
            maxHeap.offer(n);
        }

        while(minHeap.size() < k-1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public int add(int val) {
        if(minHeap.size() > 0 && minHeap.peek() < val){
            minHeap.offer(val);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(val);
        }

        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */