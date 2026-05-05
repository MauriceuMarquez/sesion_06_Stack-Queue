package estructura.actividad2;

import estructura.interfaces.Queue;
import estructura.exceptions.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);

        if (first == null) {
            first = aux;
            last = aux;
        } else {
            last.setNext(aux);
            last = aux;
        }
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (first == null) {
            throw new ExceptionIsEmpty("Queue is empty");
        }

        E data = first.getData();
        first = first.getNext();

        if (first == null) {
            last = null;
        }

        return data;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (first == null) {
            throw new ExceptionIsEmpty("Queue is empty");
        }

        return first.getData();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        String result = "";
        Node<E> current = first;

        while (current != null) {
            result += current.getData() + " ";
            current = current.getNext();
        }

        return result;
    }
}