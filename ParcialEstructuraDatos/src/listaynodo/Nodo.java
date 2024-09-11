/**
 * 
 */
package listaynodo;

/**
 * 
 */
public class Nodo<T> {
	T elemento;
    Nodo siguiente;

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public T getElemento() {
        return elemento;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
}
