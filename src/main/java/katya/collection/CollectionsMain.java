package katya.collection;

public class CollectionsMain {

    public static void main(String[] args) {
        System.out.println("проверка работы с двусвязным списком");
        testLinkedList();
        System.out.println("проверка работы с очередью");
        testQueue();
    }

    private static void testLinkedList(){
        LinkedList linkedList = new LinkedList();
        boolean result = linkedList.isEmpty();
        System.out.println(result);
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(17);
        linkedList.add(68);
        linkedList.add("75");
        linkedList.add(new LinkedList());
        System.out.println(linkedList);
        System.out.println(linkedList.searchByObject(5));
        linkedList.deleteByIndex(2);
        System.out.println(linkedList);
        System.out.println(linkedList.getNodeByIndex(1));
    }

    private static void testQueue(){
        Queue queue = new Queue();
        queue.add(2);
        System.out.println(queue);
        queue.add(5);
        queue.add(7);
        queue.add(new Queue());
        System.out.println(queue);
        queue.peek();
        boolean result = queue.isEmpty();
        System.out.println(result);
    }
}


