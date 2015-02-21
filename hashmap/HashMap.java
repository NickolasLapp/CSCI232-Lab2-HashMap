package hashmap;

import java.lang.reflect.Array;
import binarytree.BinaryTree;
import binarytree.Node;

public class HashMap<T extends Comparable<T>> {
    private BinaryTree<T>[] map;
    private final int DEFAULT_SIZE = 1009;

    private int size;

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.size = DEFAULT_SIZE;
        map = (BinaryTree<T>[]) Array.newInstance(BinaryTree.class, size);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int initialSize) {
        this.size = initialSize;
        map = (BinaryTree<T>[]) Array.newInstance(BinaryTree.class, size);
    }

    private int hash(T key) {
        return key.hashCode() % size;
    }

    public void insertKey(T key) {
        int hash = hash(key);

        if (null == map[hash])
            map[hash] = new BinaryTree<T>();
        map[hash].insertNode(key);
    }

    public Node<T> findKey(T key) {
        int hash = hash(key);

        if (null == map[hash])
            return null;

        return map[hash].search(key);
    }

    public static void main(String[] args) {
        HashMap<Integer> test = new HashMap<Integer>();

        for (int j = 0; j < test.size; j++)
            for (int i = j; i < 2019; i += 1009)
                test.insertKey(i);
        for (BinaryTree<Integer> cell : test.map)
            if (null != cell)
                ;
        // cell.printInOrder();

        for (int i = 1500; i < 4500; i += 11) {
            for (int j = 0; j < 2; j++) {
                Node<Integer> found = test.findKey(i);
                if (null != found)
                    System.out.println(found.getKey().toString());
                else
                    System.out.println("Unable to Find: " + i);
                test.insertKey(i);
            }
        }
    }
}