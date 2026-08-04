import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MinHeap heap = new MinHeap();

        int opcion;

        do {

            System.out.println("\n===== MENÚ MIN HEAP =====");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Ver mínimo");
            System.out.println("4. Heapify");
            System.out.println("5. Mostrar heap");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese la clave: ");
                    int clave = scanner.nextInt();

                    heap.insertar(clave);
                    System.out.println("Elemento insertado.");
                    break;

                case 2:
                    Nodo eliminado = heap.eliminarMin();

                    if (eliminado != null) {
                        System.out.println("Elemento eliminado: " + eliminado);
                    } else {
                        System.out.println("El heap está vacío.");
                    }
                    break;

                case 3:
                    Nodo minimo = heap.peek();

                    if (minimo != null) {
                        System.out.println("El mínimo es: " + minimo);
                    } else {
                        System.out.println("El heap está vacío.");
                    }
                    break;

                case 4:
                    System.out.print("¿Cuántos elementos desea ingresar? ");
                    int n = scanner.nextInt();

                    ArrayList<Nodo> lista = new ArrayList<>();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        int valor = scanner.nextInt();
                        lista.add(new Nodo(valor));
                    }

                    heap.heapify(lista);
                    System.out.println("Heap creado correctamente.");
                    break;

                case 5:
                    heap.mostrar();
                    break;

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");

            }

        } while (opcion != 6);

        scanner.close();
    }
}