package estructura.actividad2;

import estructura.exceptions.ExceptionIsEmpty;
import estructura.interfaces.Queue;

public class TestQueueLink {
    public static void main(String[] args) {

        Queue<Integer> cola = new QueueLink<>();

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        System.out.println("Cola: " + cola);

        try {
            System.out.println("Front: " + cola.front());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Removed: " + cola.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Cola: " + cola);

        try {
            System.out.println("Removed: " + cola.dequeue());
            System.out.println("Removed: " + cola.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        try {
            cola.dequeue();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}