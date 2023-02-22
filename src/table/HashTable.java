package table;

import java.util.List;
import java.util.LinkedList;


public class HashTable<T> implements MyTable<T>{
    private List<Node<T>>[] data;

    public HashTable(int size) {
        data = new LinkedList[size];

    }

    public HashTable() {
        this(5);
    }


    private int getHashCode(String key) {
        int hash = 0;
        for(char c : key.toCharArray()) {
            hash += c;
        }
        return hash;
    }

    private int getIndex(String key) {
        return getHashCode(key) % data.length;
    }
    // binary search only if the list is sorted
    private Node<T> searchNode(String key, List<Node<T>> target) {
        if(target == null) {
            return null;
        }
        for(Node<T> node: target) {
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }
    @Override
    public void put(String key,T value) {


        int idx = getIndex(key);
        List<Node<T>> targetList = data[idx];
        if(targetList == null) {
            targetList = new LinkedList<>();
            data[idx] = targetList;
        }

        Node<T> searchNode = searchNode(key, targetList);
        if(searchNode == null) {
            Node<T> node = new Node(key, value);
            targetList.add(node);
        } else {
            searchNode.value = value;
        }
    }
    @Override
    public T get(String key) {
        int idx = getIndex(key);
        Node<T> node = searchNode(key, data[idx]);
        if (node == null) {
            return (T)"no value";
        }
        return node.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(List<Node<T>> list : data) {
            if(list != null && !list.isEmpty()) {
                for (Node<T> node : list) {
                    sb.append(node);
                    sb.append("->");
                }
            }
        }

//        return sb.substring(0, sb.length()-2);
            sb.delete(sb.length()-2, sb.length());  // from -4 to right before the length
        return sb.toString();
    }
    @Override
    public T remove(String key) {
        int idx = getIndex(key);
        Node<T> node = searchNode(key, data[idx]);
        if(node != null) {
            data[idx].remove(node);
            return node.value;
        }
        return  null;
    }
}
