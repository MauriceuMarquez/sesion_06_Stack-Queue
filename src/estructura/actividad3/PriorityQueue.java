package estructura.actividad3; // pertenece al paquete actividad3

import estructura.exceptions.ExceptionIsEmpty; // importa la excepción

public interface PriorityQueue<E, N> { // interfaz genérica (E=dato, N=prioridad)
    void enqueue(E x, N pr); // inserta dato x con prioridad pr
    E dequeue() throws ExceptionIsEmpty; // elimina el de mayor prioridad
    E front() throws ExceptionIsEmpty; // retorna el primero (mayor prioridad)
    E back() throws ExceptionIsEmpty; // retorna el último (menor prioridad)
    boolean isEmpty(); // verifica si la cola está vacía
}