package org.gig.binarytree;

/**
 * binary tree node.
 * <p><h2>Change History</h2>
 * 2016/4/22 | G | created
 * </p>
 *
 * @author G
 * @version 1.0.0
 */
public class BinaryTreeNode<T> {
    private T element;

    private BinaryTreeNode<T> leftChild;

    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

}
