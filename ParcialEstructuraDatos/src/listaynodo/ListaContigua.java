package listaynodo;

public class ListaContigua {
    private int[] elementos;
    private int tamanio;

    public ListaContigua() {
        elementos = new int[10]; // Tamaño inicial del arreglo
        tamanio = 0;
    }

    public void agregarFinal(int elemento) {
        if (tamanio == elementos.length) {
            // Si el arreglo está lleno, duplica su tamaño
            int[] nuevoElementos = new int[elementos.length * 2];
            for (int i = 0; i < tamanio; i++) {
                nuevoElementos[i] = elementos[i];
            }
            elementos = nuevoElementos;
        }
        elementos[tamanio] = elemento;
        tamanio++;
    }

    public int getTamanio() {
        return tamanio;
    }

    public int getElemento(int indice) {
        if (indice >= 0 && indice < tamanio) {
            return elementos[indice];
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
    }

    public boolean contiene(int elemento) {
        for (int i = 0; i < tamanio; i++) {
            if (elementos[i] == elemento) {
                return true;
            }
        }
        return false;
    }
}
