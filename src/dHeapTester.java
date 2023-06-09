/*
 * Name: Krish Prasad
 * PID:  A17402508
 */

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Title: dHeapTester Description: This program tests a Heap with d branching factor
 *
 * @author Krish Prasad
 * @since ${05-22-2023}
 */
public class dHeapTester {
    @Test
    public void dTest() {

        dHeap<Integer> heap = new dHeap<>(3, 10, true);

        heap.add(24);
        heap.add(50);
        heap.add(31);
        heap.add(53);

        Assertions.assertEquals("53 24 31 50", heap.toString());

        int removed = heap.remove();
        Assertions.assertEquals(53, removed);
        Assertions.assertEquals("50 24 31", heap.toString());

        heap.add(56);
        heap.add(38);
        heap.add(46);

        Assertions.assertEquals("56 46 31 50 24 38", heap.toString());

        removed = heap.remove();
        Assertions.assertEquals(56, removed);
        Assertions.assertEquals("50 46 31 38 24", heap.toString());


        dHeap<Integer> heap2 = new dHeap<>(4, 10, false);

        heap2.add(11);
        heap2.add(25);
        heap2.add(19);
        heap2.add(37);

        Assertions.assertEquals("11 25 19 37", heap2.toString());

        removed = heap2.remove();
        Assertions.assertEquals(11, removed);
        Assertions.assertEquals("19 25 37", heap2.toString());
        heap2.add(8);
        heap2.add(15);
        heap2.add(29);


        Assertions.assertEquals("8 25 37 19 15 29", heap2.toString());

        removed = heap2.remove();
        Assertions.assertEquals(8, removed);
        Assertions.assertEquals("15 25 37 19 29", heap2.toString());


    }

    public void defaultHeapTests() {
        dHeap<Integer> heap = new dHeap<>();
        Assertions.assertEquals(0, heap.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> heap.remove());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            heap.remove();
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> heap.element());

        // Test the constructor with initial capacity
        int initialCapacity = 10;
        dHeap<Integer> heap2 = new dHeap<>(initialCapacity);
        Assertions.assertEquals(0, heap2.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> heap2.remove());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> heap2.element());

        // Test add() and remove()

        dHeap<Integer> heap3 = new dHeap<>(initialCapacity);
        heap3.add(5);
        heap3.add(10);
        heap3.add(3);
        heap3.add(8);

        Assertions.assertEquals(4, heap3.size());
        Assertions.assertEquals(10, heap3.remove());
        Assertions.assertEquals(3, heap3.remove());
        Assertions.assertEquals(5, heap3.remove());
        Assertions.assertEquals(8, heap3.remove());
        Assertions.assertEquals(0, heap3.size());

        // Test clear()
        heap3.add(15);
        heap3.add(20);
        heap3.add(10);

        heap3.clear();

        Assertions.assertEquals(0, heap3.size());

        // Test element() after clearing the heap
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> heap3.element());
    }


}
