package queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuePractice {
    public static Queue<Integer> reverseQueueRecursion(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()) {
            stack.push(q.poll());
        }

        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }

        return q;
    }

    public static Queue<Integer> reverse(Queue<Integer> q) {
        if(q.isEmpty()) {
            return q;
        }
        int target = q.poll();
        q = reverse(q);
        q.offer(target);
        return q;
    }




    public static void main(String[] args) {
        Queue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        System.out.println(reverseQueueRecursion(queue));
        System.out.println(reverse(queue));

    }



}

// 
