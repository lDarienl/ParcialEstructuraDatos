/**
 * 
 */
package ejercicio7;

import java.util.Scanner;

import listaynodo.ListaEncadenada;
import listaynodo.Nodo;

/**
 * 
 */
public class Main7 {
	
	static ListaEncadenada<Integer> lista = new ListaEncadenada<>();

	  public static void crearLista(){
		  for (int mes = 1; mes <= 12; mes++) {
	            for (int semana = 1; semana <= 4; semana++) {
	                for (int dia = 1; dia <= 7; dia++) {
	                    int temperatura = (int) (Math.random() * 30);
	                    lista.agregarFinal(mes);
	                    lista.agregarFinal(semana);
	                    lista.agregarFinal(dia);
	                    lista.agregarFinal(temperatura);
	                }
	            }
	        }
	    }
	  
	  public static double tempProm(int mesBuscado) {
		    ListaEncadenada listaTemp = new ListaEncadenada();
		    Nodo aux = lista.getInicio();
		    int mes, temperatura;
		    int sumaTemperaturas = 0;
		    int contador = 0;

		    while (aux != null) {
		        if (aux.getSiguiente() == null) break;
		        mes = (Integer) aux.getElemento();
		        aux = aux.getSiguiente();
		        
		        if (mes == mesBuscado) {  
		            Nodo nodoSemana = aux;  
		            aux = aux.getSiguiente();
		            if (aux == null || aux.getSiguiente() == null) break;
		            aux = aux.getSiguiente();
		            temperatura = (Integer) aux.getElemento();
		            
		            listaTemp.agregarFinal(mes);
		            listaTemp.agregarFinal(nodoSemana.getElemento());
		            listaTemp.agregarFinal(temperatura);
		            
		            sumaTemperaturas += temperatura;
		            contador++;
		        }
		        
		        aux = aux.getSiguiente();
		    }

		    if (contador == 0) {
		        return 0;
		    }
		    return (double) sumaTemperaturas / contador;
		}
	        
	  public static void SemMayorTempTrimestre() {
	        ListaEncadenada listaTemp = new ListaEncadenada();
	        Nodo aux = lista.getInicio();
	        int semanaMayor = 0, mesMayor = 0, temperaturaMayor = 0;
	        int sumaTempSemana = 0, contadorDias = 0;
	        int mes, semana, dia, temperatura;

	        while (aux != null) {
	            if (aux.getSiguiente() == null) break;
	            mes = (Integer) aux.getElemento(); 
	            aux = aux.getSiguiente();
	            
	            if (mes >= 1 && mes <= 3) {  
	                semana = (Integer) aux.getElemento();
	                aux = aux.getSiguiente(); 
	                dia = (Integer) aux.getElemento();
	                aux = aux.getSiguiente();
	                temperatura = (Integer) aux.getElemento();

	                listaTemp.agregarFinal(mes);
	                listaTemp.agregarFinal(semana);
	                listaTemp.agregarFinal(temperatura);

	                if (temperatura > temperaturaMayor) {
	                    temperaturaMayor = temperatura;
	                    semanaMayor = semana;
	                    mesMayor = mes;
	                    sumaTempSemana = temperatura;  
	                    contadorDias = 1;
	                } else if (semana == semanaMayor && mes == mesMayor) {
	                    sumaTempSemana += temperatura;
	                    contadorDias++;
	                }
	            }
	            aux = aux.getSiguiente();
	        }

	        double tempPromedioSemana = (double) sumaTempSemana / contadorDias;
	        System.out.println("Semana con mayor temperatura en el primer trimestre: Semana " + semanaMayor + " del mes " + mesMayor);
	        System.out.println("Temperatura promedio de esa semana: " + tempPromedioSemana);
	    } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		crearLista();
        lista.mostrar();
        
        System.out.print("Ingrese el mes (1-12) del que desea ver la temperatura promedio: ");
        int mesBuscar = scanner.nextInt();

        double temperaturaPromedio = tempProm(mesBuscar);
        System.out.println("Temperatura promedio del mes " + mesBuscar + ": " + temperaturaPromedio);

        SemMayorTempTrimestre();
        scanner.close();
	}

}
