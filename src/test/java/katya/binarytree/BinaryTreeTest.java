package katya.binarytree;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBinaryTree(){
        BinaryTree<Integer,String> binaryTree = new BinaryTree<>();
        binaryTree.add(3,"tree");
        binaryTree.add(0,"zero");
        binaryTree.add(7,"seven");
        binaryTree.add(10,"ten");
        binaryTree.add(4,"four");
       // binaryTree.delete(7);
        binaryTree.add(7,"seven");
       // binaryTree.delete(3);

    }


}
