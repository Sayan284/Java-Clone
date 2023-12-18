
public class NodeBinary<T> {
    T data;
    NodeBinary<T> next;

    NodeBinary(T data) {
        this.data = data;
        next = null;
    }
}