/**
 * 
 */
package listaynodo;

/**
 * 
 */
public class ListaEncadenada<T> {
	private Nodo inicio;
    private int elemento;

    public ListaEncadenada() {
        this.inicio = null;
        this.elemento = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean esVacia() {
        return inicio == null;
    }

    // Método para obtener el primer elemento
    public int getElemento() {
        if (!esVacia()) {
            return elemento;
        } else {
            throw new RuntimeException("La lista está vacía");
        }
    }

    // Método para agregar un elemento al final de la lista
    public void agregarFinal(T dato) {
        Nodo nuevo = new Nodo();
        nuevo.setElemento(dato);
        if (esVacia()) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        elemento++;
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarInicio(T dato) {
        Nodo nuevo = new Nodo();
        nuevo.setElemento(dato);
        if (!esVacia()) {
            nuevo.siguiente = inicio;
        }
        inicio = nuevo;
        elemento++;
    }

    // Método para agregar un elemento en una posición entre nodos
    public void agregarEntreNodo(T dato, int index) {
        if (index < 0 || index > elemento) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo nuevo = new Nodo();
        nuevo.setElemento(dato);
        if (index == 0) {
            agregarInicio(dato);
        } else {
            Nodo aux = inicio;
            for (int i = 1; i < index; i++) {
                aux = aux.siguiente;
            }
            nuevo.siguiente = aux.siguiente;
            aux.setSiguiente(nuevo);
            elemento++;
        }
    }

    // Método para borrar un elemento específico
    public boolean borrar(T dato) {
        if (esVacia()) {
            return false;
        }
        if (inicio.elemento == dato) {
            inicio = inicio.siguiente;
            elemento--;
            return true;
        }
        Nodo aux = inicio;
        while (aux.siguiente != null && aux.siguiente.elemento != dato) {
            aux = aux.siguiente;
        }
        if (aux.siguiente == null) {
            return false;
        } else {
            aux.siguiente = aux.siguiente.siguiente;
            elemento--;
            return true;
        }
    }

    // Método para borrar un elemento por índice
    public boolean borrar(int index) {
        if (index < 0 || index >= elemento) {
            return false;
        }
        if (index == 0) {
            inicio = inicio.siguiente;
        } else {
            Nodo aux = inicio;
            for (int i = 1; i < index; i++) {
                aux = aux.siguiente;
            }
            aux.siguiente = aux.siguiente.siguiente;
        }
        elemento--;
        return true;
    }

    // Método para mostrar todos los elementos
    public void mostrar() {
        if (esVacia()) {
            System.out.println("La lista está vacía");
        } else {
            Nodo aux = inicio;
            while (aux != null) {
                System.out.print(aux.elemento + " -> ");
                aux = aux.getSiguiente();
            }
            System.out.println("null");
        }
    }

    // Método para modificar un elemento en una posición
    public void modificar(int index, int nuevoValor) {
        if (index < 0 || index >= elemento) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo aux = inicio;
        for (int i = 0; i < index; i++) {
            aux = aux.siguiente;
        }
        aux.elemento = nuevoValor;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Nodo getInicio() {
        return inicio;
    }
}

