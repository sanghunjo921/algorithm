package queue;

public class MyStack<T>{
    private MyQueue<T> queue;

    public MyStack() {
        queue = new MyQueue<T>();


    }
    // stack first in last out
    // queue First in first out
    public T  pop() {
       T target ;
       MyQueue<T> temp = new MyQueue<>();
        if(queue.isEmpty()){
            return null;
        }

        while(queue.size() > 1) {
            temp.offer(queue.poll());
        }
       target = queue.poll();
        queue = temp;
        temp = null;
        return target;
    }
    public boolean push(T value) {
        return queue.offer(value);
    }
}


