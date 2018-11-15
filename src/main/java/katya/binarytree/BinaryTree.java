package katya.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTree<K extends Comparable<K>,V> {

    private Node<K, V> head;

    private class Node<K, V> {
        private K key;
        private Node<K, V> left;
        private Node<K, V> right;
        private List<V> values;
        private int height;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            values = new ArrayList<>();
            values.add(value);
            this.left = left;
            this.right = right;
            height = 0;
        }
    }

    public void add(K key, V value) {
        boolean elementContains = contains(key);
        head = insert(key, value, head, false, elementContains);
    }

    public void addForTreeMap(K key, V value) {
        boolean elementContains = contains(key);
        head = insert(key, value, head, true, elementContains);
    }

    public List<V> get(K key) {
        return containsRecursive(key, head);
    }

    private Node<K, V> insert(K key, V value, Node<K, V> current, boolean replaceValue, boolean notBalance) {
        if (current == null) {
            current = new Node<>(key, value, null, null);
        }

        int compareResult = current.key.compareTo(key);
        if (compareResult == 0) {
            current.values.add(value);
        }
        if (compareResult == -1) {
            current.left = insert(key, value, current.left, replaceValue, notBalance);
        } else {
            if (compareResult == 1) {
                current.right = insert(key, value, current.right, replaceValue, notBalance);
            }
        }
        if (notBalance) {
            return current;
        } else {
            return balance(current);
        }
    }


    public void delete(K key) {
        deleteRecurcive(key, head);
    }

    private Node<K, V> deleteRecurcive(K key, Node<K, V> current) {
        if (current == null) throw new NoSuchElementException("Element not found");
        int compareResult = current.key.compareTo(key);
        if (compareResult < 0) {
            current.left = deleteRecurcive(key, current.left);
        } else {
            if (compareResult > 0) {
                current.right = deleteRecurcive(key, current.right);
            } else {
                if (current.left == null && current.right == null) {
                    return null;

                } else {
                    if (current.left == null) {
                        return current.right;
                    } else {
                        if (current.right == null) {
                            return current.left;
                        } else {
                            Node<K, V> substituteNode = getSmallLeft(current.left);
                            current.key = substituteNode.key;
                            current.values = substituteNode.values;
                            current.right = deleteRecurcive(substituteNode.key, current.right);

                        }
                    }
                }
            }
        }
        return balance(current);
    }


        private Node<K, V> getSmallLeft(Node<K, V> current) {
            if (current.left != null){
                getSmallLeft(current.left);
            }
            return current;
        }


        public boolean contains(K key) {
            try {
                containsRecursive (key, head);
            } catch (NoSuchElementException e) {
                return false;
            }
            return true;
        }

        private List<V> containsRecursive(K key, Node<K, V> current) {
            List<V> resultList = new ArrayList<V>();
            if (current == null) {
                throw new NoSuchElementException("No such element in tree");
            } else {
                if (0 > current.key.compareTo(key)) {
                    resultList = containsRecursive(key, current.right);
                } else {
                    if (0 < current.key.compareTo(key)) {
                        resultList = containsRecursive(key, current.left);
                    } else {
                        if (current.key.compareTo(key) == 0) {
                            return resultList;
                        }
                        resultList = current.values;
                    }
                }
            }
            return resultList;
        }

        private int height(Node n) {
            if (n == null) {
                return 0;
            } else {
                return n.height;
            }
        }

        private Node<K, V> balance(Node<K, V> n) {
            fixHeight(n);
            if (balanceCoef(n) == 2) {
                if (balanceCoef(n.right) < 0) {
                    n.right = rightRotate(n.right);
                }
                return leftRotate(n);
            }
            if (balanceCoef(n) == -2) {
                if (balanceCoef(n.left) > 0) {
                    n.left = leftRotate(n.left);
                }
                return rightRotate(n);
            }
            return n;
        }

        private int balanceCoef(Node<K, V> n) {
            return height(n.right) - height(n.left);
        }

        private void fixHeight(Node<K, V> n) {
            int leftHeight = height(n.left);
            int rightHeight = height(n.right);
            n.height = Math.max(leftHeight, rightHeight) + 1;
        }

        private Node<K, V> rightRotate(Node<K, V> current) {
            Node<K, V> newTop = current.left;
            current.left = newTop.right;
            newTop.right = current;
            fixHeight(newTop);
            fixHeight(current);
            return newTop;
        }

        private Node<K, V> leftRotate(Node<K, V> current) {
            Node<K, V> newTop = current.right;
            current.right = newTop.left;
            newTop.left = current;
            fixHeight(newTop);
            fixHeight(current);
            return newTop;
        }

    }