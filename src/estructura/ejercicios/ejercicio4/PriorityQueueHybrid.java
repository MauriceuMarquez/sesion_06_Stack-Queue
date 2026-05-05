package estructura.ejercicios.ejercicio4; // paquete solicitado

import estructura.exceptions.ExceptionIsEmpty; // excepción

class PriorityQueueHybrid<E, N extends Comparable<N>> {

    class EntryNode { // nodo interno (dato + valor secundario)
        E data; // dato
        N value; // valor secundario (para ordenar dentro del nivel)

        EntryNode(E data, N value) { // constructor
            this.data = data; // asigna dato
            this.value = value; // asigna valor
        }
    }

    private Node<EntryNode>[] levels; // arreglo de colas (niveles de prioridad)
    private int nLevels; // número de niveles

    public PriorityQueueHybrid(int n) { // constructor
        this.nLevels = n; // guarda cantidad de niveles
        levels = new Node[n]; // crea arreglo

        for (int i = 0; i < n; i++) { // inicializa cada nivel
            levels[i] = null; // cada cola inicia vacía
        }
    }

    public void enqueue(E x, int priority, N value) { // inserta elemento
        EntryNode newEntry = new EntryNode(x, value); // crea entrada
        Node<EntryNode> newNode = new Node<>(newEntry); // crea nodo

        Node<EntryNode> head = levels[priority]; // obtiene cabeza del nivel

        if (head == null) { // si el nivel está vacío
            levels[priority] = newNode; // inserta como primero
            return;
        }

        if (value.compareTo(head.getData().value) < 0) { // menor valor va adelante
            newNode.setNext(head); // nuevo apunta al anterior
            levels[priority] = newNode; // se vuelve cabeza
            return;
        }

        Node<EntryNode> current = head; // nodo auxiliar

        while (current.getNext() != null &&
               value.compareTo(current.getNext().getData().value) >= 0) { // orden ascendente
            current = current.getNext(); // avanza
        }

        newNode.setNext(current.getNext()); // enlaza nuevo
        current.setNext(newNode); // inserta en lista
    }

    public E dequeue() throws ExceptionIsEmpty { // elimina respetando prioridad

        for (int i = nLevels - 1; i >= 0; i--) { // desde mayor prioridad
            if (levels[i] != null) { // si hay elementos
                E data = levels[i].getData().data; // obtiene dato
                levels[i] = levels[i].getNext(); // elimina primero
                return data; // retorna
            }
        }

        throw new ExceptionIsEmpty("Queue empty"); // si todo está vacío
    }

    public String toString() { // muestra estructura interna
        String result = "";

        for (int i = nLevels - 1; i >= 0; i--) { // recorre niveles
            result += "Nivel " + i + ": "; // imprime nivel

            Node<EntryNode> current = levels[i]; // nodo actual

            if (current == null) { // si está vacío
                result += "vacio\n";
                continue;
            }

            while (current != null) { // recorre lista del nivel
                result += "(" + current.getData().data + "," +
                          current.getData().value + ") -> ";
                current = current.getNext(); // avanza
            }

            result += "\n";
        }

        return result;
    }
}