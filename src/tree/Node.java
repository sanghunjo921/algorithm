package tree;

public class Node<T extends Comparable<T>> implements Comparable<T>{
    T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }


    @Override
    public int compareTo(T o) {
        Node<T> target = (Node<T>)o;
        return data.compareTo(target.data);
    }

    public String toString() {
        return data.toString();
    }
}
