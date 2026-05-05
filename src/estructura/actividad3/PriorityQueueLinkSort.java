package estructura.actividad3; // paquete actividad3

import estructura.exceptions.ExceptionIsEmpty; // importa excepción

class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    // N debe poder compararse para ordenar prioridades

    class EntryNode { // clase interna que guarda dato + prioridad
        E data; // dato
        N priority; // prioridad

        EntryNode(E data, N priority) { // constructor
            this.data = data; // asigna dato
            this.priority = priority; // asigna prioridad
        }
    }

    private Node<EntryNode> first; // inicio de la lista (mayor prioridad)
    private Node<EntryNode> last;  // final de la lista (menor prioridad)

    public PriorityQueueLinkSort() { // constructor
        this.first = null; // lista vacía
        this.last = null;  // lista vacía
    }

    public void enqueue(E x, N pr) { // insertar respetando prioridad
        EntryNode newEntry = new EntryNode(x, pr); // crea objeto con dato+prioridad
        Node<EntryNode> newNode = new Node<>(newEntry); // crea nodo

        if (isEmpty()) { // si está vacía
            first = last = newNode; // el nuevo nodo es primero y último
            return; // termina
        }

        if (pr.compareTo(first.getData().priority) > 0) { // si nueva prioridad es mayor que la del primero
            newNode.setNext(first); // nuevo apunta al anterior primero
            first = newNode; // nuevo pasa a ser el primero
            return; // termina
        }

        Node<EntryNode> current = first; // nodo auxiliar para recorrer

        while (current.getNext() != null && // mientras exista siguiente
               pr.compareTo(current.getNext().getData().priority) <= 0) { // y prioridad sea menor o igual
            current = current.getNext(); // avanza en la lista
        }

        newNode.setNext(current.getNext()); // nuevo apunta al siguiente
        current.setNext(newNode); // actual apunta al nuevo

        if (newNode.getNext() == null) { // si se insertó al final
            last = newNode; // actualiza último
        }
    }

    public E dequeue() throws ExceptionIsEmpty { // eliminar el primero
        if (isEmpty()) // si está vacía
            throw new ExceptionIsEmpty("Queue is empty"); // lanza error

        E aux = this.first.getData().data; // guarda el dato del primero
        this.first = this.first.getNext(); // avanza el primero

        if (this.first == null) // si quedó vacía
            this.last = null; // también last es null

        return aux; // retorna el dato eliminado
    }

    public E front() throws ExceptionIsEmpty { // obtener primero
        if (isEmpty()) // si está vacía
            throw new ExceptionIsEmpty("Queue is empty"); // error

        return first.getData().data; // retorna dato del primero
    }

    public E back() throws ExceptionIsEmpty { // obtener último
        if (isEmpty()) // si está vacía
            throw new ExceptionIsEmpty("Queue is empty"); // error

        return last.getData().data; // retorna dato del último
    }

    public boolean isEmpty() { // verificar si está vacía
        return first == null; // true si no hay elementos
    }

    public String toString() { // mostrar lista
        String result = ""; // cadena resultado
        Node<EntryNode> current = first; // comienza desde el primero

        while (current != null) { // recorre toda la lista
            result += "(" + current.getData().data + "," + current.getData().priority + ") -> "; // concatena dato y prioridad
            current = current.getNext(); // avanza
        }

        return result; // retorna cadena
    }
}