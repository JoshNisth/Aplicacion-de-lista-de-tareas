import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }
    /**
     * La funcion se encarga de agregar una tarea a la lista y a un archivo de texto
     * @param sc  usa el parametro sc para poder escribir por teclado la descripcion necesaria
     */
    public static void agregarTarea(Scanner sc) {
        System.out.println("Ingrese la descripción de la nueva tarea:");
        sc.nextLine();
        String descripcion = sc.nextLine();
        try (PrintWriter writer = new PrintWriter(new FileWriter("tareas.txt", true))) {
            writer.println(descripcion + ",false");
            System.out.println("Tarea agregada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al agregar la tarea: " + e.getMessage());
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas pendienrtes para cambiar su estado a completadas
     * en caso de que no hubieran tareas pendientes, manda un mensaje
     * @param sc : es el parametro se encarga de seleciconar por teclado
     * escribiendo el numero de la tarea que se quiera completar
     */
    public static void marcarTareaComoCompletada(Scanner sc) {
        mostrarTareas(false);
        System.out.print("Ingrese el número de la tarea que desea marcar como completada: ");
        int numeroTarea = sc.nextInt();
        ArrayList<String> nuevasTareas = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("tareas.txt"))) {
            int i = 1;
            for (; fileScanner.hasNextLine(); i++) {
                String line = fileScanner.nextLine();
                boolean tareaPendiente = !Boolean.parseBoolean(line.split(",")[1]);
                if (tareaPendiente) { 
                    if (i == numeroTarea) {
                        nuevasTareas.add(line.substring(0, line.lastIndexOf(",") + 1) + "true");
                        System.out.println("La tarea ha sido marcada como completada.");
                    } else {
                        nuevasTareas.add(line);
                    }
                }
            }
            if (i == 1) {
                System.out.println("No hay tareas pendientes.");
            } else if (numeroTarea > i - 1) {
                System.out.println("Número de tarea no válido.");
            } else {
                actualizarTareas(nuevasTareas);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo de tareas no encontrado.");
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas para eliminarlas de la lista
     * en caso de que no hubieran tareas pendientes, manda un mensaje
     * @param sc esl parametro se encarga de seleciconar por teclado la tarea a eliminar del listado
     * escribiendo el numero de la tarea
     */
    public static void eliminarTareas(Scanner sc) {
        mostrarListaTareas();
        System.out.print("Ingrese el número de la tarea que desea eliminar: ");
        int numeroTarea = sc.nextInt();
        ArrayList<String> nuevasTareas = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("tareas.txt"))) {
            for (int i = 0; fileScanner.hasNextLine(); i++) {
                String line = fileScanner.nextLine();
                if (i != numeroTarea - 1) {
                    nuevasTareas.add(line);
                } else {
                    System.out.println("La tarea ha sido eliminada.");
                }
            }
            actualizarTareas(nuevasTareas);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo de tareas no encontrado.");
        }
    }
    /**
     * La funcion se encarga de desplegar el listado de tareas en general del archivo de texto
     * en caso de que no hubieran tareas, manda un mensaje
     */
    public static void mostrarListaTareas() {
        System.out.println("------- Lista de Tareas ------");
        try (Scanner fileScanner = new Scanner(new File("tareas.txt"))) {
            int i = 1;
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String estado = Boolean.parseBoolean(parts[1]) ? "completada" : "pendiente";
                System.out.println(i + ". " + parts[0] + " - " + estado);
                i++;
            }
            if (i == 1) {
                System.out.println("No hay tareas guardadas.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo de tareas no encontrado.");
        }
    }
    /**
     * La funcion se encarca de mostrar solo 1 tipo de tarea o las completas o las pendientes
     * @param completadas el parametro se encarga de dividir
     * si es false muestra las pendientes, si es true muestra las completadas
     * del archivo de texto
     */
    public static void mostrarTareas(boolean completadas) {
        try (Scanner fileScanner = new Scanner(new File("tareas.txt"))) {
            int i = 1;
            boolean algunaTarea = false;
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                boolean tareaCompletada = Boolean.parseBoolean(parts[1]);
                if (tareaCompletada == completadas) {
                    String estado = tareaCompletada ? "completada" : "pendiente";
                    System.out.println(i + ". " + parts[0] + " - " + estado);
                    algunaTarea = true;
                    i++;
                }
            }
            if (!algunaTarea) {
                if (completadas) {
                    System.out.println("No hay tareas completadas.");
                } else {
                    System.out.println("No hay tareas pendientes.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo de tareas no encontrado.");
        }
    }
    public static void mostrarTareasCompletadas() {
        System.out.println("------- Tareas Completadas ------");
        mostrarTareas(true);
    }

    public static void mostrarTareasPendientes() {
        System.out.println("------- Tareas Pendientes ------");
        mostrarTareas(false);
    }
    /**
     * esto solo ese encarga de actualizar el archivo de texto al agregar nuevas tareas
     * @param nuevasTareas usa la lista nueva que se crea en el programa para
     * fusionarla con el archivo de texto
     */
    private static void actualizarTareas(ArrayList<String> nuevasTareas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("tareas.txt"))) {
            for (String tarea : nuevasTareas) {
                writer.println(tarea);
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar las tareas: " + e.getMessage());
        }
    }
}