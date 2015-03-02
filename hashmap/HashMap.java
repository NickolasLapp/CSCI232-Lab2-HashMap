package hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import binarytree.BinaryTree;
import binarytree.Node;

public class HashMap<T extends Comparable<T>> {
    private BinaryTree<T>[] map;
    private final static int DEFAULT_SIZE = 1009;

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
        int hashCode = key.hashCode() % size;
        return hashCode > 0 ? hashCode : -hashCode;
    }

    public void insertKey(T key) {
        if (null == key)
            return;

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

    private void displayTree() {
        for (BinaryTree<T> cell : map)
            if (null != cell)
                cell.printInOrder();
    }

    public static char getChoice() {
        String s = getInput();
        return s != null ? s.charAt(0) : 0;
    }

    public static String getInput() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read input. Please retry.");
        }
        return s;
    }

    public static void main(String[] args) {
        String inputString = null;
        int size = HashMap.DEFAULT_SIZE;
        char dataType = 0;
        HashMap localMap = null;

        while (true) {
            System.out.println("Enter letter of Key[T]ype [I]nputValue [S]earch [D]isplay Si[Z]e");
            char choice = Character.toLowerCase(getChoice());
            switch (choice) {
            case 'z':
                System.out.println("Please enter starting size for the hashmap");
                size = Integer.parseInt(getInput());
                if (size <= 0) {
                    size = HashMap.DEFAULT_SIZE;
                    System.out.println("Please enter a size greater than zero.");
                }
                break;
            case 't':
                System.out.println("Enter Map Type. Supported Types are [I]nteger, [S]tring, [D]ouble");
                switch (dataType = Character.toLowerCase(getChoice())) {
                case 'd':
                    localMap = new HashMap<Double>(size);
                    break;
                case 'i':
                    localMap = new HashMap<Integer>(size);
                    break;
                case 's':
                    localMap = new HashMap<String>(size);
                    break;
                default:
                    System.out.print("Invalid entry\n");
                }

                break;
            case 'i':
                System.out.println("Please enter a value to insert of type " + dataType + ":");
                inputString = getInput();
                switch (dataType) {
                case 'd':
                    Double d = Double.parseDouble(inputString);
                    localMap.insertKey(d);
                    break;
                case 'i':
                    Integer i = Integer.parseInt(inputString);
                    localMap.insertKey(i);
                    break;
                case 's':
                    localMap.insertKey(inputString);
                    break;
                default:
                    System.out.println("Please create a hashmap by specifying a keytype first");
                    break;
                }
                break;
            case 's':
                System.out.println("Please enter a value to search for of type " + dataType + ":");
                inputString = getInput();
                switch (dataType) {
                case 'd':
                    Double d = Double.parseDouble(inputString);
                    if (null != localMap.findKey(d))
                        System.out.println("Found:" + inputString);
                    else
                        System.out.println(inputString + ": not Found");
                    break;
                case 'i':
                    Integer i = Integer.parseInt(inputString);
                    if (null != localMap.findKey(i))
                        System.out.println("Found:" + inputString);
                    else
                        System.out.println(inputString + ": not Found");
                    break;
                case 's':
                    if (null != localMap.findKey(inputString))
                        System.out.println("Found:" + inputString);
                    else
                        System.out.println(inputString + ": not Found");
                    break;
                default:
                    System.out.println("Please create a hashmap by specifying a keytype first");
                    break;
                }
                break;
            case 'd':
                System.out.println("HashMap:");
                localMap.displayTree();
                break;
            default:
                System.out.println("Invalid entry");
            }
        }
    }

}