package binarytree;

import java.io.IOException;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void inOrder(Node<T> node) {
        if (null == node)
            return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    public void insertNode(T key) {
        Node<T> toInsert = new Node<T>(key);
        if (root == null) {
            root = toInsert;
            return;
        }
        Node<T> insertWhere = root;

        for (;;) {
            if (toInsert.compareTo(insertWhere) > 0) {
                if (insertWhere.right == null) {
                    insertWhere.right = toInsert;
                    break;
                } else {
                    insertWhere = insertWhere.right;
                }
            } else if (toInsert.compareTo(insertWhere) < 0) {
                if (insertWhere.left == null) {
                    insertWhere.left = toInsert;
                    break;
                } else {
                    insertWhere = insertWhere.left;
                }
            } else
                break; // node already in tree, skip it
        }
    }

    private void printInOrder() {
        inOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree<Integer> test = new BinaryTree<Integer>();
        // test.insertNode(10);
        // test.insertNode(5);
        // test.insertNode(15);
        // test.insertNode(2);
        // test.insertNode(17);
        // test.insertNode(6);
        // test.insertNode(1);
        // test.insertNode(12);
        // test.insertNode(13);
        // test.insertNode(4);

        // for (int i = 1000; i > 0; i--)
        // test.insertNode(i);
        test.printInOrder();
    }
}
