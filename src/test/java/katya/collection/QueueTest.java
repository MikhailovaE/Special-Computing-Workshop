package katya.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue queue = new Queue();
        assertTrue( queue.isEmpty());
        queue.add(2);
        queue.add(5);
        queue.add(7);
        queue.add(new Queue());
        assertEquals(2, queue.peek());
        assertFalse( queue.isEmpty());
    }
}
