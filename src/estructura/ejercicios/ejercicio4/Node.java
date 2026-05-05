package estructura.ejercicios.ejercicio4; // paquete

public class Node<E> { // nodo genérico

    private E data; // dato
    private Node<E> next; // siguiente

    public Node(E data) { // constructor
        this.data = data; // asigna dato
        this.next = null; // siguiente null
    }

    public E getData() { return data; } // retorna dato

    public Node<E> getNext() { return next; } // retorna siguiente

    public void setNext(Node<E> next) { this.next = next; } // asigna siguiente
}