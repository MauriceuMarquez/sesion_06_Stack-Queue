package estructura.ejercicios.ejercicio2;

import estructura.actividad1.QueueArray;
import estructura.exceptions.ExceptionIsEmpty;
import estructura.interfaces.Queue;

public class Ejercicio2 {
    public static void main(String[] args) {

        Queue<Integer> cola = new QueueArray<>(5);

        // Encolar clientes iniciales
        cola.enqueue(101);
        cola.enqueue(102);
        cola.enqueue(103);
        cola.enqueue(104);
        cola.enqueue(105);

        // Intentar encolar uno más
        try {
            cola.enqueue(106);
        } catch (RuntimeException e) {
            System.out.println("Cola llena");
        }

        // Desencolar 2 clientes
        try {
            System.out.println("Atendiendo cliente: " + cola.dequeue());
            System.out.println("Atendiendo cliente: " + cola.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Mostrar el frente
        try {
            System.out.println("Cliente en frente: " + cola.front());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Encolar más clientes (verifica circularidad)
        cola.enqueue(106);
        cola.enqueue(107);

        // Desencolar todos
        try {
            while (true) {
                System.out.println("Atendiendo cliente: " + cola.dequeue());
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println("Cola vacía");
        }

        // Intentar desencolar uno más
        try {
            cola.dequeue();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Cola vacía");
        }
    }
}