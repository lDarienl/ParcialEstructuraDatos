/**
 * 
 */
package ejercicio7;

import java.util.Random;
import listaynodo.ListaEncadenada;
import listaynodo.ListaContigua;

/**
 * 
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        // Crea las dos listas contiguas
        ListaContigua listaContigua1 = new ListaContigua();
        ListaContigua listaContigua2 = new ListaContigua();
        
        // Crea la lista encadenada
        ListaEncadenada listaEncadenada = new ListaEncadenada();
        
        // Crea las listas contiguas con datos aleatorios
        crearListasContiguas(listaContigua1, listaContigua2);
        
        // Muestra las listas contiguas
        System.out.println("Lista Contigua 1:");
        mostrarListaContigua(listaContigua1);
        System.out.println("Lista Contigua 2:");
        mostrarListaContigua(listaContigua2);
        
        // Crea la lista encadenada con datos aleatorios
        crearListaEncadenada(listaContigua1, listaContigua2, listaEncadenada);
        
        // Muestra la lista encadenada
        System.out.println("Lista Encadenada:");
        listaEncadenada.mostrar();
    }
    
    // Crea las listas contiguas con datos aleatorios
    public static void crearListasContiguas(ListaContigua listaContigua1, ListaContigua listaContigua2) {
        Random random = new Random();
        
        // Genera la cantidad de elementos aleatorios para la lista contigua 1
        int cantidadElementos1 = random.nextInt(21) + 10; // Entre 10 y 30
        
        // Asigna datos aleatorios a la lista contigua 1
        for (int i = 0; i < cantidadElementos1; i++) {
            listaContigua1.agregarFinal(random.nextInt(501) + 50); // Entre 50 y 550
        }
        
        // Genera la cantidad de elementos aleatorios para la lista contigua 2
        int cantidadElementos2 = random.nextInt(36) + 5; // Entre 5 y 40
        
        // Asigna datos aleatorios a la lista contigua 2
        for (int i = 0; i < cantidadElementos2; i++) {
            listaContigua2.agregarFinal(random.nextInt(501) + 50); // Entre 50 y 550
        }
    }
    
    // Crea la lista encadenada con datos aleatorios
    public static void crearListaEncadenada(ListaContigua listaContigua1, ListaContigua listaContigua2, ListaEncadenada listaEncadenada) {
        // Recorre la lista contigua 1
        for (int i = 0; i < listaContigua1.getTamanio(); i++) {
            // Obtiene el elemento de la lista contigua 1
            int elemento = listaContigua1.getElemento(i);
            
            // Verifica si el elemento es impar y no está en la lista contigua 2
            if (elemento % 2 != 0 && !listaContigua2.contiene(elemento)) {
                listaEncadenada.agregarFinal(elemento);
            }
        }
        
        // Recorre la lista contigua 2
        for (int i = 0; i < listaContigua2.getTamanio(); i++) {
            // Obtiene el elemento de la lista contigua 2
            int elemento = listaContigua2.getElemento(i);
            
            // Verifica si el elemento es par y no está en la lista contigua 1
            if (elemento % 2 == 0 && !listaContigua1.contiene(elemento)) {
                listaEncadenada.agregarFinal(elemento);
            }
        }
    }

    // Muestra la lista contigua por consola
    public static void mostrarListaContigua(ListaContigua listaContigua) {
        for (int i = 0; i < listaContigua.getTamanio(); i++) {
            System.out.print(listaContigua.getElemento(i) + " ");
        }
        System.out.println();
    }
}