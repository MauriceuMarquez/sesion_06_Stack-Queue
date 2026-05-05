package estructura.ejercicios.ejercicio1; // paquete donde se encuentra la interfaz

import estructura.exceptions.ExceptionIsEmpty; // importa la excepción

public interface Stack<E> { // interfaz genérica

    void push(E x); // inserta elemento en la pila

    E pop() throws ExceptionIsEmpty; // elimina el elemento del tope

    E top() throws ExceptionIsEmpty; // retorna el elemento del tope

    boolean isEmpty(); // verifica si la pila está vacía
}
