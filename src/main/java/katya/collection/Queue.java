package katya.collection;

public class Queue {
    private LinkedList queue = new LinkedList();

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }


    //добавление элемента в конец очереди
    public void add(Object object) { queue.add(object); }


    public Object deleteFromQueue()
    {
        Object object = queue.getNodeByIndex(0);
        queue.deleteByIndex(0);

        return object;
    }

    public Object peek() {
        return queue.getNodeByIndex(0);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
