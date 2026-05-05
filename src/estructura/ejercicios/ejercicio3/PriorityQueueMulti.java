package estructura.ejercicios.ejercicio3;

import estructura.actividad2.QueueLink;
import estructura.exceptions.ExceptionIsEmpty;
import estructura.interfaces.Queue;

public class PriorityQueueMulti<E> {

    private Queue<E>[] queues;
    private int levels;

    @SuppressWarnings("unchecked")
    public PriorityQueueMulti(int levels) {
        this.levels = levels;
        queues = (Queue<E>[]) new Queue[levels];

        for (int i = 0; i < levels; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    public void enqueue(E x, int priority) {
        queues[priority].enqueue(x);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola vacía");
    }
}