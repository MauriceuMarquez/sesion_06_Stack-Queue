package estructura.ejercicios.ejercicio3;

import estructura.exceptions.ExceptionIsEmpty;

public class TestEjercicio3 {
    public static void main(String[] args) {

        PriorityQueueMulti<String> pq = new PriorityQueueMulti<>(3);

        pq.enqueue("A", 0);
        pq.enqueue("B", 2);
        pq.enqueue("C", 1);
        pq.enqueue("D", 2);

        try {
            System.out.println(pq.dequeue()); // B
            System.out.println(pq.dequeue()); // D
            System.out.println(pq.dequeue()); // C
            System.out.println(pq.dequeue()); // A
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}