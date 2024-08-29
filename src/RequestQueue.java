
import java.util.LinkedList;

/**
 * The RequestQueue object is simply a quickly-made queue data structure using the Java LinkedList API
 *      as its only base of implementation. Meant to only take in requests.
 * @param <Request> the requests that are being stored in this data structure.
 * While implementing the queue as a subclass of LinkedList does the work for me, I included the front and rear data
 *      fields on the class, even if it's of the Request class and not a node class.
 */
public class RequestQueue<Request> extends LinkedList<Request> {
    private Request front;
    private Request rear;
    /**
     * The constructor being used to make the queue.
     */
    public RequestQueue() {
        super();
        front = null;
        rear = null;
    }
    /**
     * The method used to add a request to the queue.
     * @param x the request being appended
     */
    public void enqueue(Request x) {
        if(front == null) {
            front = x;
            rear = x;
        } else {
            rear = x;
        }
        super.add(x);
    }
    /**
     * The method used to return the top of the queue (FIFO)
     * @return the first request in the queue
     */
    public Request dequeue() throws NullPointerException {
        if(front == null) {
            throw new NullPointerException();
        }
        Request y = super.getFirst();
        super.removeFirst();
        if(super.isEmpty()) {
            front = null;
            rear = null;
        } else {
            front = super.getFirst();
        }
        return y;
    }
    /**
     * Getter method for the number of requests in the queue
     * @return the number of requests
     */
    public int size() {
        return super.size();
    }
    /**
     * Method used to specify if the queue is empty or not
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return (front == null);
    }
    public void reverse() {
        if(this.isEmpty()) {
            return;
        }
        Request temp = this.dequeue();
        reverse();
        this.enqueue(temp);
    }
}
