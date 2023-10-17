package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {
private QueueLinkedList<Integer> queue;
    @BeforeEach
    void setUp() {
        queue =new QueueLinkedList<>();
    }

    @Test
    void testFifoOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }


    @Test
    void testExceptions() {
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
        assertThrows(QueueEmptyException.class, () -> queue.front());

        queue.enqueue(1);
        queue.dequeue();

        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
        assertThrows(QueueEmptyException.class, () -> queue.front());


    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());

        queue.enqueue(1);
        assertEquals(1, queue.size());


        queue.dequeue();
        assertEquals(0, queue.size());
    }
    @Test
    void testSizeAfterClear() {
        queue.enqueue(1);
        queue.enqueue(2);

        queue.clear();

        assertEquals(0, queue.size());
    }
    @Test
    void testIsEmpty() {

        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIsEmptyAfterClear() {
        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.clear();
        assertTrue(queue.isEmpty());
    }
}