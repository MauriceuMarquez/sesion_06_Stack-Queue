package estructura.ejercicios.ejercicio1; // paquete

import estructura.exceptions.ExceptionIsEmpty; // importa excepción

class StackLink<E> implements Stack<E> { // implementa la interfaz

    private Node<E> top; // referencia al tope de la pila

    public StackLink() { // constructor
        this.top = null; // pila vacía
    }

    public void push(E x) { // insertar al inicio (tope)
        Node<E> newNode = new Node<>(x); // crea nuevo nodo con el dato
        newNode.setNext(top); // el nuevo nodo apunta al anterior tope
        top = newNode; // el nuevo nodo se convierte en el tope
    }

    public E pop() throws ExceptionIsEmpty { // eliminar el primero
        if (isEmpty()) // si está vacía
            throw new ExceptionIsEmpty("Stack is empty"); // lanza error

        E aux = top.getData(); // guarda el dato del tope
        top = top.getNext(); // el siguiente nodo pasa a ser el nuevo tope
        return aux; // retorna el dato eliminado
    }

    public E top() throws ExceptionIsEmpty { // retornar el primero
        if (isEmpty()) // si está vacía
            throw new ExceptionIsEmpty("Stack is empty"); // error

        return top.getData(); // retorna el dato del tope
    }

    public boolean isEmpty() { // verificar si está vacía
        return top == null; // true si no hay nodos
    }

    public String toString() { // mostrar desde el tope hacia abajo
        String result = ""; // cadena resultado
        Node<E> current = top; // comienza desde el tope

        while (current != null) { // recorre la pila
            result += current.getData() + " -> "; // concatena el dato
            current = current.getNext(); // avanza al siguiente nodo
        }

        return result; // retorna cadena
    }
}