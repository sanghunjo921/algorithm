package table;

public class Node<T>  implements  Comparable<Node<T>> {
    public String key;
    public T value;

    public Node(String key, T value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key  + "," + value + "]";
    }


    @Override
    public int compareTo(Node<T> o) {
        return key.compareTo(o.key);
    }
}
