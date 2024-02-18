/*
Autor: Josue Nisthaus
EJERCICIO 2
Cree un programa que use una ArrayList de números reales. El programa debe permitirle
mostrar un menú donde pueda agregar números, buscar números, cambiar números,
eliminar números e insertar números en las posiciones especificadas.
*/
import java.util.*;

public class MenuTareas {
    public static void main(String[] args) {
        ArrayList <Integer> nLista = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        for(; i != 7; ) {
            System.out.println("------- MENU ------");
            System.out.println("1. Agregar Tarea:");
            System.out.println("2. Marcar Tarea Completada:");
            System.out.println("3. Eliminar Tarea:");
            System.out.println("4. Generar reporte general de tareas:");
            System.out.println("5. Generar reporte Tareas completadas:");
            System.out.println("6. Generar reporte Tareas pendientes:");
            System.out.println("7. Salir");
            System.out.println("--------------------------");
            System.out.print("Seleccione una opción: ");
            i = sc.nextInt();
            switch(i) {
                case 1:
                    pausa();
                    break;
                case 2:
                    pausa();
                    break;
                case 3:
                    pausa();
                    break;
                case 4:
                    pausa();
                    break;
                case 5:
                    pausa();
                    break;
                case 6:
                    pausa();
                    break;
                case 7:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    pausa();
                    break;
            }
        }
        sc.close();
    }
    

    //void para que la pantalla se muestre el contenido hasta que el usuario quiera cmabiarlo
    static void pausa() {
        System.out.println("\nPresione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }



}

