package ejercicio7;

import java.util.Scanner;
import listaynodo.ListaEncadenada;
import listaynodo.Nodo;

public class Main7 {

    // Lista encadenada para almacenar los datos de clima
    static ListaEncadenada<Integer> lista = new ListaEncadenada<>();

    // Función que crea la lista de datos climáticos con todos los meses, semanas y días del año
    public static void crearLista() {
        for (int mes = 1; mes <= 12; mes++) {
            for (int semana = 1; semana <= 4; semana++) {
                for (int dia = 1; dia <= 7; dia++) {
                    int temperatura = (int) (Math.random() * 30); // Temperatura aleatoria
                    lista.agregarFinal(mes); // Agregar mes a la lista
                    lista.agregarFinal(semana); // Agregar semana a la lista
                    lista.agregarFinal(dia); // Agregar día a la lista
                    lista.agregarFinal(temperatura); // Agregar temperatura a la lista
                }
            }
        }
    }

    // Función que calcula la temperatura promedio de un mes específico
    public static double tempProm(int mesBuscado) {
    	ListaEncadenada<Integer> listaTemp = new ListaEncadenada<>();// Lista temporal para almacenar registros del mes
        Nodo aux = lista.getInicio();
        int mes, temperatura;
        int sumaTemperaturas = 0;
        int contador = 0;

        // Recorremos la lista original
        while (aux != null) {
            if (aux.getSiguiente() == null) break;
            mes = (Integer) aux.getElemento(); // Extraemos el mes
            aux = aux.getSiguiente();

            // Filtramos los registros por el mes buscado
            if (mes == mesBuscado) {
                Nodo nodoSemana = aux; // Nodo que contiene la semana
                aux = aux.getSiguiente();
                if (aux == null || aux.getSiguiente() == null) break;
                aux = aux.getSiguiente(); // Nodo que contiene la temperatura
                temperatura = (Integer) aux.getElemento();

                // Agregamos los registros a la lista temporal
                listaTemp.agregarFinal(mes);
                listaTemp.agregarFinal((Integer) nodoSemana.getElemento());
                listaTemp.agregarFinal(temperatura);

                // Acumulamos la temperatura para el promedio
                sumaTemperaturas += temperatura;
                contador++;
            }

            aux = aux.getSiguiente(); // Avanzamos al siguiente registro
        }

        // Calculamos el promedio
        if (contador == 0) {
            return 0; // No hay registros para el mes buscado
        }
        return (double) sumaTemperaturas / contador;
    }

    // Función que encuentra la semana con mayor temperatura en el primer trimestre
    public static void SemMayorTempTrimestre() {
    	ListaEncadenada<Integer> listaTemp = new ListaEncadenada<>(); // Lista temporal para almacenar registros del primer trimestre
        Nodo aux = lista.getInicio();
        int semanaMayor = 0, mesMayor = 0, temperaturaMayor = 0;
        int sumaTempSemana = 0, contadorDias = 0;
        int mes, semana, dia, temperatura;

        // Recorremos la lista original
        while (aux != null) {
            if (aux.getSiguiente() == null) break;
            mes = (Integer) aux.getElemento(); // Extraemos el mes
            aux = aux.getSiguiente();

            // Filtramos los registros del primer trimestre
            if (mes >= 1 && mes <= 3) {
                semana = (Integer) aux.getElemento(); // Extraemos la semana
                aux = aux.getSiguiente();
                dia = (Integer) aux.getElemento(); // Extraemos el día
                aux = aux.getSiguiente();
                temperatura = (Integer) aux.getElemento(); // Extraemos la temperatura

                // Agregamos los registros a la lista temporal
                listaTemp.agregarFinal(mes);
                listaTemp.agregarFinal(semana);
                listaTemp.agregarFinal(temperatura);

                // Verificamos si es la mayor temperatura
                if (temperatura > temperaturaMayor) {
                    temperaturaMayor = temperatura;
                    semanaMayor = semana;
                    mesMayor = mes;
                    sumaTempSemana = temperatura; // Iniciamos el cálculo del promedio para esa semana
                    contadorDias = 1;
                } else if (semana == semanaMayor && mes == mesMayor) {
                    sumaTempSemana += temperatura;
                    contadorDias++;
                }
            }
            aux = aux.getSiguiente(); // Avanzamos al siguiente registro
        }

        // Calculamos el promedio de la semana con mayor temperatura
        double tempPromedioSemana = (double) sumaTempSemana / contadorDias;
        System.out.println("Semana con mayor temperatura en el primer trimestre: Semana " + semanaMayor + " del mes " + mesMayor);
        System.out.println("Temperatura promedio de esa semana: " + tempPromedioSemana);
    }

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear lista de datos climáticos
        crearLista();
        lista.mostrar();

        // Pedir al usuario el mes que desea ver
        System.out.print("Ingrese el mes (1-12) del que desea ver la temperatura promedio: ");
        int mesBuscar = scanner.nextInt();
        
        // Calcula si el numero para buscar el mes esta afuera del rango de meses (1-12)
        if (mesBuscar > 12 || mesBuscar < 1) {
        	System.out.println("Ese mes no existe xd");
        } else {
        	// Calcular y mostrar la temperatura promedio del mes seleccionado
            double temperaturaPromedio = tempProm(mesBuscar);
            System.out.println("Temperatura promedio del mes " + mesBuscar + ": " + temperaturaPromedio);

        }
        	
        // Calcular y mostrar la semana con mayor temperatura del primer trimestre
        SemMayorTempTrimestre();

        scanner.close();
    }
}
