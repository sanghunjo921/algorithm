package queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyQueue<T> implements Queue<T> {

    private T[] data;
    private int size;
    private int start;
    private int end;

    public MyQueue() {
        data = (T[]) new Object[5];
        size = 0;
        start = 0;
        end = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T e : data) {
            if (e.equals((T) o)) {
                return true;
            }
        }
        return false;
    }

    @Override

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean offer(T t) {
        if (size == data.length) {
            return false;
        }
        if (end == data.length) {
            end = 0;
        }
        data[end++] = t;
        size++;
        return true;

    }

    @Override
    public T remove() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public T poll() {
        int idx = start;
        if (start == data.length-1) {
            start = 0;

        } else{
            start ++;
        }

        size--;

        return data[idx];
    }

    @Override
    public T element() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = start; i < start + size; i++) {

            sb.append(data[i % data.length]);
            if (i != start + size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
