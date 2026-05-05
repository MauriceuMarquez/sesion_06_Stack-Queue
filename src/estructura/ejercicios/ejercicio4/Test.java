
package estructura.ejercicios.ejercicio4; // paquete

public class Test {

    public static void main(String[] args) throws Exception {

        PriorityQueueHybrid<String, Integer> pq = new PriorityQueueHybrid<>(3); // 3 niveles

        pq.enqueue("A", 2, 5); // A prioridad 2 valor 5
        pq.enqueue("B", 2, 1); // B prioridad 2 valor 1
        pq.enqueue("C", 1, 3); // C prioridad 1 valor 3
        pq.enqueue("D", 2, 3); // D prioridad 2 valor 3

        System.out.println(pq); // muestra estructura

        System.out.println(pq.dequeue()); // B
        System.out.println(pq.dequeue()); // D
        System.out.println(pq.dequeue()); // A
        System.out.println(pq.dequeue()); // C
    }
}