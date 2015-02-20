package binarytree;

public class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    Node<K, V> left, right;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = right = null;
    }

    public int compareTo(Node<K, V> compareTo) {
        return key.compareTo(compareTo.key);
    }
}
