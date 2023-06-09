/*
 * Name: Krish Prasad
 * PID:  A17402508
 */

/**
 * Priority Queue Implementation using dHeap.
 *
 * @param <T> the type of elements held in this collection
 * @author KrishPrasad
 * @since ${05-22-2023}
 */
public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> pQueue;

    /**
     * Constructor that creates a new priority queue
     *
     * @param initialSize the given size
     */
    public MyPriorityQueue(int initialSize) {
        // Create a new d-ary heap with a branching factor of 4 and the given initial size
        pQueue = new dHeap<>(4, initialSize, false);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot be
     * null.
     *
     * @param element Element to be inserted.
     * @return returns true
     * @throws NullPointerException if the element received is null.
     */
    public boolean offer(T element) throws NullPointerException {
        // Check if the element is null and throw an exception if so
        if (element == null) {
            throw new NullPointerException();
        }
        pQueue.add(element);
        return true;
    }

    /**
     * Retrieve and remove the head of this Priority Queue (largest element), or null if the
     * queue is empty.
     *
     * @return The head of the queue (largest element), or null if queue is empty.
     */
    public T poll() {
        // Check if the priority queue is empty and return null if so

        if (pQueue.size() == 0) {
            return null;
        } else {
            return pQueue.remove();
        }
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
        // Clear the priority queue by removing all elements
        pQueue.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     *
     * @return the head of the queue, null if the queue is empty
     */
    public T peek() {
        // Check if the priority queue is empty and return null if so
        if (pQueue.size() == 0) {
            return null;
        }
        return pQueue.element();
    }

    /**
     * Indicates whether the queue is empty.
     *
     * @return true is the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        // Check if the priority queue is empty
        return pQueue.size() == 0;
    }

}
