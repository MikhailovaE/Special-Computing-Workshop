package katya.collection;

public class LinkedList {
    private Node nodeBegin; //узел первый
    private int size; //количество элементов в листе

    //добавление элемента в конец списка
    public void add(Object object) {
        Node newNode = new Node(object);
        if (size == 0)  //если список пуст
        {
            nodeBegin = newNode;
            ++size;
            return;
        }

        Node currentNode = nodeBegin;

        //идем до конца списка
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
        newNode.setPrev(currentNode);
        ++size;
    }

    //проверка на пустоту
    public boolean isEmpty() {
        return (size == 0);
    }

    //взятие элемента по индексу
    public Object getNodeByIndex(int index) {
        chechIndexInBounds(index);
        Node currentNode = nodeBegin;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getObject();
    }

    private void chechIndexInBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound: index: " + index + " size: " + size);
        }
    }

    //поиск элемента в списке
    public boolean searchByObject(Object object) {
        Node currentNode = nodeBegin;
        for (int i = 0; i < size; i++) {
            if (currentNode.getObject().equals(object)) //сравниваем по содержимому
            {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    //удаление по индексу
    public boolean deleteByIndex(int index) {
        chechIndexInBounds(index);
        //частный случай
        if (index == 0) {
            Node buff = nodeBegin.getNext();
            buff.setPrev(null);
            nodeBegin = buff;
            size--;
            return false;
        }

        //частный случай
        if (size == 1) {
            nodeBegin = null;
            size--;
            return true;
        }

        Node currentNode = nodeBegin;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();//ищем удаляемый узел
        }

        Node buff = currentNode;

        if (currentNode.getNext() == null) {
            currentNode.getPrev().setNext(null);
            size--;
            return true;
        }

        currentNode.getPrev().setNext(buff.getNext());
        currentNode.getNext().setPrev(buff.getPrev());
        size--;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node currentNode = nodeBegin;
        while (currentNode != null) {
            stringBuilder.append(currentNode.toString()).append(" ");
            currentNode = currentNode.getNext();
        }

        return stringBuilder.toString();
    }

    private class Node {
        private Node prev;
        private Node next;
        private Object object;

        public Node(Object object, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.object = object;
        }

        public Node(Object value) {
            this(value, null, null);
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        @Override
        public String toString() {
            return object.toString();
        }
    }

}

