class QueueArray {
    private int[] arr;
    private int front;
    private int rear;

    public QueueArray(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (rear == arr.length - 1) {
            throw new RuntimeException("Queue Overflow");
        }
        arr[++rear] = x;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        return arr[front++];
    }

    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public int size() {
        return rear - front + 1;
    }
}