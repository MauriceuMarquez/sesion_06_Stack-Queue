package estructura.actividad1;

import estructura.interfaces.Queue;
import estructura.exceptions.ExceptionIsEmpty;

public class TestQueue {
    public static void main(String[] args) {

        Queue<Integer> cola = new QueueArray<>(5);

        // Insertar elementos
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        // Mostrar la cola
        System.out.println("Cola: " + cola);

        // Ver el frente
        try {
            System.out.println("Front: " + cola.front());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Eliminar un elemento
        try {
            System.out.println("Removed: " + cola.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Mostrar la cola después de eliminar
        System.out.println("Cola: " + cola);

        // Vaciar la cola
        try {
            System.out.println("Removed: " + cola.dequeue());
            System.out.println("Removed: " + cola.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Intentar eliminar cuando está vacía
        try {
            cola.dequeue();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}