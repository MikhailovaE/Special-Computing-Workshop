package katya.binarytree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TreeMapTest {
    @Test
    public void testTreeMap() {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        assertTrue(treeMap.isEmpty());
        treeMap.put(1,"one");
        treeMap.put(4,"four");
        treeMap.put(7,"seven");
        treeMap.delete(1);
        treeMap.size();
        treeMap.get(4);
    }
}