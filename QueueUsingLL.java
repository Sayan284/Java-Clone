
public class QueueUsingLL<T> {

    private NodeBinary<T> front;
    private NodeBinary<T> rear;
    private int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    T front() throws QueueEmptyException2 {
        if (size == 0) {
            throw new QueueEmptyException2();
        }
        return front.data;
    }

    void enqueue(T element) {
        NodeBinary<T> newNode = new NodeBinary<>(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;

    }

    T dequeue() throws QueueEmptyException2 {
        if (size == 0) {
            throw new QueueEmptyException2();
        }

        T temp = front.data;
        front = front.next;
        if (size == 1) {
            rear = null;
        }
        size--;

        return temp;
    }


}