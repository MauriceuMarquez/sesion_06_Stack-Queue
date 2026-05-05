
package estructura.actividad3; // paquete actividad3

public class Node<E> { // clase nodo genérico

    private E data; // almacena el dato
    private Node<E> next; // referencia al siguiente nodo

    public Node(E data) { // constructor
        this.data = data; // asigna el dato
        this.next = null; // siguiente inicialmente null
    }

    public E getData() { return data; } // retorna el dato

    public Node<E> getNext() { return next; } // retorna el siguiente nodo

    public void setNext(Node<E> next) { this.next = next; } // asigna el siguiente nodo
}