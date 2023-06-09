import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyPriorityQueueTester {
    private MyPriorityQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new MyPriorityQueue<>(10); // Initial size of 10
    }

    @Test
    public void testOffer() {
        // Offer elements to the priority queue
        Assertions.assertTrue(queue.offer(5));
        Assertions.assertTrue(queue.offer(10));
        Assertions.assertTrue(queue.offer(3));
    }

    @Test
    public void testPoll() {
        // Test poll on an empty queue
        Assertions.assertNull(queue.poll());

        // Offer elements to the priority queue
        queue.offer(5);
        queue.offer(10);
        queue.offer(3);

        // Poll elements from the priority queue
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertEquals(5, queue.poll());
        Assertions.assertEquals(10, queue.poll());
        Assertions.assertNull(queue.poll());
    }

    @Test
    public void testClear() {
        // Offer elements to the priority queue
        queue.offer(5);
        queue.offer(10);
        queue.offer(3);

        // Clear the priority queue
        queue.clear();

        // Check if the queue is empty
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertNull(queue.poll());
    }

    @Test
    public void testPeek() {
        // Test peek on an empty queue
        Assertions.assertNull(queue.peek());

        // Offer elements to the priority queue
        queue.offer(5);
        queue.offer(10);
        queue.offer(3);

        // Peek at the top element
        Assertions.assertEquals(3, queue.peek());
    }

    @Test
    public void testIsEmpty() {
        // Check if the queue is initially empty
        Assertions.assertTrue(queue.isEmpty());

        // Offer an element to the priority queue
        queue.offer(5);

        // Check if the queue is not empty
        Assertions.assertFalse(queue.isEmpty());
    }
}


