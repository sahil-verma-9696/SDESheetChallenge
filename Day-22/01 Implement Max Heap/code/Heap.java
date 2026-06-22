import java.util.*;

public class Heap {

    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    // ==========================
    // Utility Methods
    // ==========================

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ==========================
    // Insert
    // ==========================

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 &&
                heap.get(index) > heap.get(parent(index))) {

            swap(index, parent(index));
            index = parent(index);
        }
    }

    // ==========================
    // Peek (Maximum)
    // ==========================

    public int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    // ==========================
    // Extract Max
    // ==========================

    public int extractMax() {

        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int max = heap.get(0);

        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

    private void heapifyDown(int index) {

        int size = heap.size();

        while (true) {

            int largest = index;
            int left = leftChild(index);
            int right = rightChild(index);

            if (left < size &&
                heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size &&
                heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    // ==========================
    // Build Heap O(n)
    // ==========================

    public void buildHeap(int[] arr) {

        heap.clear();

        for (int num : arr) {
            heap.add(num);
        }

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // ==========================
    // Delete Element at Index
    // ==========================

    public void delete(int index) {

        if (index >= heap.size()) {
            return;
        }

        swap(index, heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (index < heap.size()) {
            heapifyUp(index);
            heapifyDown(index);
        }
    }

    // ==========================
    // Size
    // ==========================

    public int size() {
        return heap.size();
    }

    // ==========================
    // Is Empty
    // ==========================

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // ==========================
    // Clear Heap
    // ==========================

    public void clear() {
        heap.clear();
    }

    // ==========================
    // Print Heap
    // ==========================

    public void printHeap() {
        System.out.println(heap);
    }

    // ==========================
    // Main Method
    // ==========================

    public static void main(String[] args) {

        Heap heap = new Heap();

        heap.insert(10);
        heap.insert(30);
        heap.insert(20);
        heap.insert(50);
        heap.insert(40);

        heap.printHeap();

        System.out.println("Max: " + heap.peek());

        System.out.println("Extracted: " + heap.extractMax());

        heap.printHeap();

        heap.delete(1);

        heap.printHeap();
    }
}