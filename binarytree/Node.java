package binarytree;

public class Node<K extends Comparable<K>> implements Comparable<K> {
    private K key;
    private Node<K> left, right;

    public Node(K key) {
        this.key = key;
        this.left = this.right = null;
    }

    public int compareTo(Node<K> compareTo) {
        return getKey().compareTo(compareTo.getKey());
    }

    @Override
    public int compareTo(K keyToCompare) {
        return getKey().compareTo(keyToCompare);
    }

    public Node<K> getLeft() {
        return left;
    }

    public Node<K> getRight() {
        return right;
    }

    public K getKey() {
        return key;
    }

    public void setRight(Node<K> right) {
        this.right = right;
    }

    public void setLeft(Node<K> left) {
        this.left = left;
    }
}
