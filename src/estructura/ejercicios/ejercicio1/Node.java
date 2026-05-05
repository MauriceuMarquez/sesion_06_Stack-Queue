package estructura.ejercicios.ejercicio1; // paquete actividadPilaLista

public class Node<E> { // clase nodo genérico

    private E data; // dato almacenado
    private Node<E> next; // referencia al siguiente nodo

    public Node(E data) { // constructor
        this.data = data; // asigna el dato
        this.next = null; // siguiente es null
    }

    public E getData() { return data; } // retorna dato

    public Node<E> getNext() { return next; } // retorna siguiente nodo

    public void setNext(Node<E> next) { this.next = next; } // asigna siguiente nodo
}
