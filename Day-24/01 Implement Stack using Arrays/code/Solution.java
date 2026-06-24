class StackArray {
    private int[] arr;
    private int top;

    public StackArray(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top == arr.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}