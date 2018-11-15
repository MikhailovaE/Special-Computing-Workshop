package katya.binarytree;

public class TreeMap <K extends Comparable<K>, V >  {

    private BinaryTree<K,V> tree = new BinaryTree();
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        size++;
        tree.addForTreeMap(key,value);
    }

    public V get(K key) {
        return tree.get(key).get(0);
    }

    public void delete(K key) {
        size--;
        tree.delete(key);
    }


    public boolean containsKey(K key) {

        return tree.contains(key);
    }
}
