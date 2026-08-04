import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Nodo> monticulo;

    //Constructor
    public MinHeap() {
        monticulo = new ArrayList<>();
    }

    public void insertar(int clave) {
        Nodo nuevo = new Nodo(clave);
        monticulo.add(nuevo);
        upHeapify(monticulo.size() - 1);
    }

    private void upHeapify(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;
            if (monticulo.get(indice).getClave() < monticulo.get(padre).getClave()) {
            intercambiar(indice, padre);
            indice = padre;
            }
            else {
            break;
            }
        }
    }

    public Nodo eliminarMin() {
        if (monticulo.isEmpty()) {
            return null;
        }

        Nodo minimo = monticulo.get(0);

        Nodo ultimo = monticulo.remove(monticulo.size() - 1);

        if (!monticulo.isEmpty()) {
            monticulo.set(0, ultimo);
            downHeapify(0);
        }

        return minimo;
    }

    private void downHeapify(int indice) {
        int menor = indice;
        int izquierdo = 2 * indice + 1;
        int derecho = 2 * indice + 2;

        if (izquierdo < monticulo.size() &&
                monticulo.get(izquierdo).getClave() < monticulo.get(menor).getClave()) {
            menor = izquierdo;
        }

        if (derecho < monticulo.size() &&
                monticulo.get(derecho).getClave() < monticulo.get(menor).getClave()) {
            menor = derecho;
        }

        if (menor != indice) {
            intercambiar(indice, menor);
            downHeapify(menor);
        }
    }

    public Nodo peek() {
        if (monticulo.isEmpty()) {
            return null;    }

        return monticulo.get(0);
    }

    public void heapify(ArrayList<Nodo> lista) {
        monticulo = lista;
        for (int i = (monticulo.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
    }
        }

    private void intercambiar(int i, int j) {
        Nodo aux = monticulo.get(i);
        monticulo.set(i, monticulo.get(j));
        monticulo.set(j, aux);
    }

    public void mostrar() {
        for (Nodo n : monticulo) {
            System.out.print(n + " ");
        }
        System.out.println();
    }


}
