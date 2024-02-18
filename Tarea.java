import java.util.ArrayList;
import java.util.Scanner;

public class Tarea {
    private String descripcion;
    private boolean completada;
    private static ArrayList<Tarea> listaTareas = new ArrayList<>();

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }
    
    /**
     * La funcion se encarga de agregar una tarea a la lista
     * @param sc  usa el parametro sc para poder escribir por teclado la descripcion necesaria
     */
    public static void agregarTarea(Scanner sc) {
        System.out.println("Ingrese la descripción de la nueva tarea:");
        sc.nextLine();
        String descripcion = sc.nextLine();
        Tarea nuevaTarea = new Tarea(descripcion);
        listaTareas.add(nuevaTarea);
        System.out.println("Tarea agregada exitosamente.");
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas pendienrtes para cambiar su estado a completadas
     * en caso de que no hubieran tareas pendientes, manda un mensaje
     * @param sc : es el parametro se encarga de seleciconar por teclado
     * escribiendo el numero de la tarea que se quiera completar
     */
    public static void marcarTareaComoCompletada(Scanner sc) {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes para marcar como completadas.");
            return;
        }
        mostrarListaTareas();
        System.out.print("Ingrese el número de la tarea que desea marcar como completada: ");
        int numeroTarea = sc.nextInt();
        if (numeroTarea >= 1 && numeroTarea <= listaTareas.size()) {
            Tarea tareaSeleccionada = listaTareas.get(numeroTarea - 1);
            tareaSeleccionada.completada = true;
            System.out.println("La tarea ha sido marcada como completada.");
        } else {
            System.out.println("Número de tarea no válido.");
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas para eliminarlas de la lista
     * en caso de que no hubieran tareas pendientes, manda un mensaje
     * @param sc esl parametro se encarga de seleciconar por teclado la tarea a eliminar del listado
     * escribiendo el numero de la tarea
     */
    public static void eliminarTareas(Scanner sc) {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas guardadas.");
        } else {
        	mostrarListaTareas();
            System.out.print("Ingrese el número de la tarea que desea eliminar: ");
            int numeroTarea = sc.nextInt();
            if (numeroTarea >= 1 && numeroTarea <= listaTareas.size()) {
                Tarea tareaSeleccionada = listaTareas.remove(numeroTarea - 1);
                System.out.println("La tarea ha sido eliminada.");
            } else {
                System.out.println("Número de tarea no válido.");
            }
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas en general
     * en caso de que no hubieran tareas pendientes, manda un mensaje
     */
    public static void mostrarListaTareas() {
        System.out.println("------- Lista de Tareas ------");
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas guardadas.");
        } else {
            for (int i = 0; i < listaTareas.size(); i++) {
                Tarea tarea = listaTareas.get(i);
                System.out.println((i + 1) + ". " + tarea.toString());
            }
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas completadas
     * usa un booleano como flag para determinar si existen tareas completadas
     * en caso de que no hubieran, manda un mensaje
     */
    public static void mostrarTareasCompletadas() {
        System.out.println("------- Tareas Completadas ------");
        boolean algunaCompleta = false;
        for (Tarea tarea : listaTareas) {
            if (tarea.completada) {
                System.out.println("- " + tarea.toString());
                algunaCompleta = true;
            }
        }
        if (!algunaCompleta) {
            System.out.println("No hay tareas completadas.");
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas pendientes
     * usa un booleano como flag para determinar si existen tareas pendientes
     * en caso de que no hubieran, manda un mensaje
     */
    public static void mostrarTareasPendientes() {
        System.out.println("------- Tareas Pendientes ------");
        boolean algunaPendiente = false;
        for (Tarea tarea : listaTareas) {
            if (!tarea.completada) {
                System.out.println("- " + tarea.toString());
                algunaPendiente = true;
            }
        }
        if (!algunaPendiente) {
            System.out.println("No hay tareas pendientes.");
        }
    }
    
    @Override
    public String toString() {
        String estado;
        if (completada) {
            estado = "Completada";
        } else {
            estado = "Pendiente";
        }
        return descripcion + " - " + estado;
    }
}
