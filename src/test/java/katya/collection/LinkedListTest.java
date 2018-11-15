package katya.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LinkedListTest {

    @Test
    public void testList() {
        LinkedList linkedList = new LinkedList();

        assertTrue( linkedList.isEmpty());

        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(17);
        linkedList.add(68);
        linkedList.add("75");
        linkedList.add(new LinkedList());

        assertEquals(10, linkedList.getNodeByIndex(1));
        assertTrue(linkedList.searchByObject(5));
        linkedList.deleteByIndex(2);

        assertEquals(10, linkedList.getNodeByIndex(1));
        assertEquals(68, linkedList.getNodeByIndex(2));
    }
}
