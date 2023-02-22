package table;

import java.util.*;

public class SortedTable<T extends Comparable<T>> implements MyTable<T> {

    List<Node<T>> data;
    private Node<T> binarySearch(Node<T> node ){
        int start = 0;
        int end = data.size()-1;

        while(start <= end) {
            int middle = end + ((start-end) /2) ;
            if(data.get(middle).compareTo(node) == 0) {
                return data.get(middle);
            }
            if(data.get(middle).compareTo(node) > 0) {
                start = middle +1 ;
            } else {
                end = middle -1 ;
            }
        }
        return null;
    }

    public SortedTable() {
        data = new ArrayList<>();
    }


    @Override
    public void put(String key, T value) {  //o(N)
        Node<T> node = new Node<>(key, value);
//        data.add(node);
//        Collections.sort(data); // O(nlogn)
        data.add(node);
        boolean isFound = false;
        for (int i = data.size() - 2; i >= 0 && !isFound; i--) {
            if (data.get(i).compareTo(node) > 0) {
                Node<T> temp = data.get(i + 1);
                data.add(i + 1, data.get(i));
                data.add(i, temp);
            } else {
                isFound = true;
            }
        }

    }
// binary search


    @Override
    public T remove(String key) {
        Node<T> target = new Node<>(key, get(key));
        data.remove(key);
        return target.value;
    }

    @Override
    public T get(String key) {
        return (T) binarySearch(new Node<>(key, null));
//
    }
}
