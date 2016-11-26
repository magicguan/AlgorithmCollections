package org.gig.binarytree;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * binary tree.
 * <p><h2>Change History</h2>
 * 2016/4/22 | G | created
 * </p>
 *
 * @author G
 * @version 1.0.0
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    private int size;

    /**
     * size method
     *
     * @return summary of all elements in tree
     */
    public int size() {
        return size;
    }

    public void reSize() {
        size = size(root);
    }

    /**
     * size of node
     * calculate the size of node
     *
     * @param node tree node
     * @return summary of all elements in node
     */
    public int size(BinaryTreeNode node) {
        if (node != null) {
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
        return 0;
    }

    /**
     * height method
     * calculate the height of tree
     *
     * @return the height of tree
     */
    public int height() {
        return height(root);
    }

    /**
     * height of node
     * calculate the height of node
     *
     * @param node tree node
     * @return summary of all elements in node
     */
    public int height(BinaryTreeNode node) {
        if (node != null) {
            return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
        }
        return 0;
    }

    /**
     * remove all elements of tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * iterator method
     * use pre-order traversal
     *
     * @return Iterator
     */
    public Iterator<BinaryTreeNode<T>> iterator() {
        return preorderTraversal();
    }

    /**
     * iterator method
     * use pre-order traversal
     *
     * @return Iterator
     */
    public Iterator<BinaryTreeNode<T>> preorderTraversal() {
        return new Itr("preorder");
    }

    /**
     * iterator method
     * use inorder traversal
     *
     * @return Iterator
     */
    public Iterator<BinaryTreeNode<T>> inorderTraversal() {
        return new Itr("inorder");
    }

    /**
     * iterator method
     * use post-order traversal
     *
     * @return Iterator
     */
    public Iterator<BinaryTreeNode<T>> postorderTraversal() {
        return new Itr("postorder");
    }

    private class Itr implements Iterator<BinaryTreeNode<T>> {
        int cursor;
        Object[] elements;

        public Itr(String type) {
            cursor = 0;
            elements = new Object[size];
            if ("preorder".equals(type))
                preorder(root);
            else if ("inorder".equals(type))
                inorder(root);
            else if ("postorder".equals(type))
                postorder(root);
            else
                throw new IllegalArgumentException("traversal type illegal!");
            cursor = 0;
        }

        private void preorder(BinaryTreeNode node) {
            if (node != null) {
                elements[cursor++] = node;
                preorder(node.getLeftChild());
                preorder(node.getRightChild());
            }
        }

        private void inorder(BinaryTreeNode node) {
            if (node != null) {
                preorder(node.getLeftChild());
                elements[cursor++] = node;
                preorder(node.getRightChild());
            }
        }

        private void postorder(BinaryTreeNode node) {
            if (node != null) {
                preorder(node.getLeftChild());
                preorder(node.getRightChild());
                elements[cursor++] = node;
            }
        }

        public boolean hasNext() {
            return cursor < size;
        }

        @SuppressWarnings("unchecked")
        public BinaryTreeNode<T> next() {
            if (hasNext())
                return (BinaryTreeNode<T>) elements[cursor++];
            else
                throw new NoSuchElementException();
        }

        public void remove() {

        }
    }

    /**
     * add a element to binary tree
     *
     * @param element element
     */
    public void add(T element) {
        if (root == null) {
            root = new BinaryTreeNode<T>(element);
            size = 1;
        } else {
            try {
                add(element, root);
            } catch (RuntimeException e) {
                if (!"stop sign".equals(e.getMessage()))
                    throw e;
            }
        }
    }

    private void add(T element, BinaryTreeNode<T> node) throws RuntimeException {
        if (node != null) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new BinaryTreeNode<T>(element));
                ++size;
                throw new RuntimeException("stop sign");
            } else if (node.getRightChild() == null) {
                node.setRightChild(new BinaryTreeNode<T>(element));
                ++size;
                throw new RuntimeException("stop sign");
            }
            add(element, node.getLeftChild());
            add(element, node.getRightChild());
        }
    }

    public BinaryTree() {
    }

    public BinaryTree(@NotNull BinaryTreeNode<T> root) {
        this.root = root;
        size = size(root);
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
}
