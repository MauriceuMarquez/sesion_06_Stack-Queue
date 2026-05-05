package estructura.interfaces;

import estructura.exceptions.ExceptionIsEmpty;

public interface Queue<E> {
    void enqueue(E x);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    boolean isEmpty();
}