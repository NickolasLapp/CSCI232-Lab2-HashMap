package binarytree;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void inOrder(Node<T> node) {
        if (null == node)
            return;
        inOrder(node.getLeft());
        System.out.print(node.getKey() + " ");
        inOrder(node.getRight());
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
                if (insertWhere.getRight() == null) {
                    insertWhere.setRight(toInsert);
                    break;
                } else {
                    insertWhere = insertWhere.getRight();
                }
            } else if (toInsert.compareTo(insertWhere) < 0) {
                if (insertWhere.getLeft() == null) {
                    insertWhere.setLeft(toInsert);
                    break;
                } else {
                    insertWhere = insertWhere.getLeft();
                }
            } else
                break; // node already in tree, skip it
        }
    }

    public Node<T> search(T key) {
        Node<T> current = root;

        while (null != current) {
            int comparisonInt = current.compareTo(key);
            if (comparisonInt < 0) {
                current = current.getRight();
            } else if (comparisonInt > 0) {
                current = current.getLeft();
            } else if (comparisonInt == 0)
                return current;
        }
        return null;
    }

    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }
}
