/*
 * Name: Krish Prasad
 * PID:  A17402508
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @param <T> the type of elements held in this collection
 * @author Krish Prasad
 * @since ${05-22-2023}
 */
public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {

    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or min

    /**
     * Initializes a binary max heap with capacity = 6
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        // Constructor for dHeap class with default settings
        this.heap = (T[]) new Comparable[6];
        this.nelems = 0;
        this.d = 2;
        this.isMaxHeap = true;

    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        // Constructor for dHeap class with specified heap size
        this.heap = (T[]) new Comparable[heapSize];
        this.nelems = 0;
        this.d = 2;
        this.isMaxHeap = true;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        // Constructor for dHeap class with specified d-ary, heap size, and heap type
        this.heap = (T[]) new Comparable[heapSize];
        this.nelems = 0;
        this.d = d;
        this.isMaxHeap = isMaxHeap;
    }

    @Override

    public int size() {
        // Returns the number of elements in the heap
        return this.nelems;
    }

    @Override
    public T remove() throws NoSuchElementException {
        // Removes and returns the root element of the heap
        if (nelems == 0) {
            throw new NoSuchElementException();
        }

        T root = heap[0];
        heap[0] = heap[nelems - 1];
        heap[nelems - 1] = null;
        nelems--;

        trickleDown(0);

        return root;
    }

    private int getChildIndex(int parentIndex, int childNumber) {
        // Returns the index of the child at the specified childNumber
        return parentIndex * d + childNumber;
    }

    private int findChildIndex(int parentIndex) {
        // Finds the index of the child with the maximum value among all children of the given parentIndex in a d-ary heap.
        int maxChildIndex = getChildIndex(parentIndex, 1);
        int numChildren = Math.min(d, nelems - maxChildIndex);

        for (int i = 2; i <= numChildren; i++) {
            int childIndex = getChildIndex(parentIndex, i);
            if (compare(heap[childIndex], heap[maxChildIndex]) > 0) {
                maxChildIndex = childIndex;
            }
        }

        return maxChildIndex;
    }

    @Override
    public void add(T item) throws NullPointerException {
        // Adds the given item to the d-ary heap. If the heap is full, it increases the capacity.
        // Then, it adds the item at the end of the heap and restores the heap property by
        // performing heapify-up operation.
        if (nelems == heap.length) {
            // Increase the capacity of the heap if it is full
            resize();
        }

        // Add the new element at the end of the heap
        heap[nelems] = item;
        nelems++;

        // Restore the heap property by performing heapify-up operation
        bubbleUp(nelems - 1);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        // Clears the d-ary heap by setting all elements to null and resetting the number of elements to zero.
        Arrays.fill(heap, null);
        nelems = 0;
    }

    @Override
    public T element() throws NoSuchElementException {
        // Returns the root element of the d-ary heap without removing it.
        if (nelems == 0) {
            throw new NoSuchElementException();
        }

        return heap[0];
    }

    private void trickleDown(int index) {
        // Performs the trickle-down operation starting from the given index.
        int childIndex = findChildIndex(index);

        while (childIndex < nelems && compare(heap[childIndex], heap[index]) > 0) {
            swap(childIndex, index);
            index = childIndex;
            childIndex = findChildIndex(index);
        }
    }

    private void bubbleUp(int index) {
        // Performs the bubble-up operation starting from the given index.
        int parentIndex = (index - 1) / d;
        while (index > 0 && compare(heap[index], heap[parentIndex]) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / d;
        }
    }

    private void swap(int i, int j) {
        // Swaps the elements at indices i and j in the heap array.
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int compare(T a, T b) {
        // Compares two elements a and b based on the heap's order (max heap or min heap) and returns the result of the comparison.
        if (isMaxHeap) {
            return a.compareTo(b);
        } else {
            return b.compareTo(a);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        // Increases the capacity of the heap by doubling its size.
        int newCapacity = this.nelems * 2;
        this.heap = Arrays.copyOf(this.heap, newCapacity);
    }

    private int parent(int index) {
        // Returns the index of the parent node of the node at the given index in the heap.
        return (index - 1) / d;
    }

    public String toString() {
        // Returns a string representation of the heap, listing all elements in the order they appear in the array.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nelems; i++) {
            sb.append(heap[i]);
            if (i != nelems - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
