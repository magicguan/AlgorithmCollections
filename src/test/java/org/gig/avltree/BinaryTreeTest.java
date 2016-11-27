package org.gig.avltree;

import org.gig.binarytree.BinaryTree;
import org.gig.binarytree.BinaryTreeNode;
import org.junit.Test;

import java.util.Iterator;

/**
 * function description.
 * <p><h2>Change History</h2>
 * 2016/4/22 | G | created
 * </p>
 *
 * @author G
 * @version 1.0.0
 */
public class BinaryTreeTest {
    @Test
    public void createBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        for (int i = 1; i < 20; i++)
            binaryTree.add(i);
        System.out.println("====== " + binaryTree.size());
        System.out.println("====== " + binaryTree.height());
        Iterator<BinaryTreeNode<Integer>> iterator;
        iterator = binaryTree.preorderTraversal();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next().getElement());
        }
        binaryTree.clear();
        System.out.println("====== " + binaryTree.size());
        System.out.println("====== " + binaryTree.height());

    }
}
