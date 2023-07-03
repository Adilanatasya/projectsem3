import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> queue;
    
    public Queue() {
        queue = new LinkedList<>();
    }
    
    public void enqueue(T item) {
        queue.addLast(item);
    }
    
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.removeFirst();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
    
    public T front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.getFirst();
    }
}