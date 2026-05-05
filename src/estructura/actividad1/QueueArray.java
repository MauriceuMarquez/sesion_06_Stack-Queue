package estructura.actividad1;

import estructura.interfaces.Queue;
import estructura.exceptions.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {

    private E[] array;
    private int front;
    private int rear;
    private int size;

    public QueueArray(int n) {
        array = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(E x) {
        if (size == array.length) {
            throw new RuntimeException("Queue is full");
        }

        rear = (rear + 1) % array.length;
        array[rear] = x;
        size++;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (size == 0) {
            throw new ExceptionIsEmpty("Queue is empty");
        }

        E data = array[front];
        front = (front + 1) % array.length;
        size--;

        return data;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (size == 0) {
            throw new ExceptionIsEmpty("Queue is empty");
        }

        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < size; i++) {
            int index = (front + i) % array.length;
            result += array[index] + " ";
        }

        return result;
    }
}