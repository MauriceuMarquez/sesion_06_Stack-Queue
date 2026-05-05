package estructura.actividad3; // paquete actividad3

public class Test {

    public static void main(String[] args) throws Exception {

        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>(); // crea cola

        pq.enqueue("A", 1); // inserta A con prioridad 1
        pq.enqueue("B", 3); // inserta B con prioridad 3 (mayor)
        pq.enqueue("C", 2); // inserta C con prioridad 2

        System.out.println(pq); // muestra la cola

        System.out.println("Front: " + pq.front()); // muestra el de mayor prioridad

        System.out.println("Back: " + pq.back()); // muestra el de menor prioridad

        System.out.println("Dequeue: " + pq.dequeue()); // elimina el primero

        System.out.println(pq); // muestra la cola actualizada
    }
}