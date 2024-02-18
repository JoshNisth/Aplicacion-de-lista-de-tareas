import java.util.*;
public class MenuTareas {
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("------- MENU  : ------");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Marcar Tarea Completada");
            System.out.println("3. Eliminar Tarea");
            System.out.println("4. Generar reporte general de tareas");
            System.out.println("5. Generar reporte Tareas completadas");
            System.out.println("6. Generar reporte Tareas pendientes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Tarea.agregarTarea(sc);
                    pausa();
                    break;
                case 2:
                    Tarea.marcarTareaComoCompletada(sc);
                    pausa();
                    break;
                case 3:
                    Tarea.eliminarTareas(sc);
                    pausa();
                    break;
                case 4:
                    Tarea.mostrarListaTareas();
                    pausa();
                    break;
                case 5:
                    Tarea.mostrarTareasCompletadas();
                    pausa();
                    break;
                case 6:
                    Tarea.mostrarTareasPendientes();
                    pausa();
                    break;
                case 7:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
        sc.close();
    }

    static void pausa() {
        System.out.println("\nPresione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
}
