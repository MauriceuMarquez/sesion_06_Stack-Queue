package estructura.ejercicios.ejercicio1; // pertenece al paquete de la pila

public class Test { // clase de prueba

    public static void main(String[] args) throws Exception { // método principal

        Stack<Integer> pila = new StackLink<>(); // crea una pila de enteros

        pila.push(10); // inserta 10 en la pila
        pila.push(20); // inserta 20 (queda encima de 10)
        pila.push(30); // inserta 30 (queda en el tope)

        System.out.println("Pila: " + pila); // muestra la pila completa

        System.out.println("Top: " + pila.top()); // muestra el elemento del tope (30)

        System.out.println("Pop: " + pila.pop()); // elimina y muestra el tope (30)

        System.out.println("Pila despues de pop: " + pila); // muestra la pila actualizada

        System.out.println("Pop: " + pila.pop()); // elimina 20
        System.out.println("Pop: " + pila.pop()); // elimina 10

        System.out.println("Pila vacia: " + pila.isEmpty()); // verifica si está vacía (true)

        // prueba de error (opcional según ejecución)
        System.out.println("Intentando pop en pila vacia:");
        System.out.println(pila.pop()); // lanza excepción
    }
}