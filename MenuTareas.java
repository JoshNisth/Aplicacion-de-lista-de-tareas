import java.util.*;

public class MenuTareas {
    static ArrayList<Tarea> listaTareas = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        while (opcion != 7) {
        	System.out.println("------- MENU  :D ------");
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
                    agregarTarea(sc);
                    break;
                case 2:
                	marcarTareaComoCompletada(sc);
                    // Marcar Tarea Completada
                    break;
                case 3:
                    // Eliminar Tarea
                    break;
                case 4:
                	mostrarListaTareas();
                    // Generar reporte general de tareas
                    break;
                case 5:
                    // Generar reporte Tareas completadas
                    break;
                case 6:
                    // Generar reporte Tareas pendientes
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


    static void agregarTarea(Scanner sc) {
        System.out.println("Ingrese la descripción de la nueva tarea:");
        sc.nextLine(); // Consumir el salto de línea pendiente
        String descripcion = sc.nextLine();
        Tarea nuevaTarea = new Tarea(descripcion);
        listaTareas.add(nuevaTarea);
        System.out.println("Tarea agregada exitosamente.");
        pausa();
    }
    
    static void marcarTareaComoCompletada(Scanner sc) {
        mostrarListaTareas();
        System.out.print("Ingrese el número de la tarea que desea marcar como completada: ");
        int numeroTarea = sc.nextInt();
        if (numeroTarea >= 1 && numeroTarea <= listaTareas.size()) {
            Tarea tareaSeleccionada = listaTareas.get(numeroTarea - 1);
            tareaSeleccionada.marcarComoCompletada();
            System.out.println("La tarea ha sido marcada como completada.");
        } else {
            System.out.println("Número de tarea no válido.");
        }
        pausa();
    }

    
    static void mostrarListaTareas() {
        System.out.println("------- Lista de Tareas ------");
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas guardadas.");
        } else {
            for (int i = 0; i < listaTareas.size(); i++) {
                Tarea tarea = listaTareas.get(i);
                System.out.println((i + 1) + ". " + tarea.toString());
            }
        }
        pausa();
    }


    static void pausa() {
        System.out.println("\nPresione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
}
