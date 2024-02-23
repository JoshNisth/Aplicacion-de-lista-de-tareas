import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Scanner;

public class TareaTest {
    @Test
    public void testMarcarTareaComoCompletada() {
        try {
            // Limpiar archivo para prueba
            PrintWriter writer = new PrintWriter("tareas.txt");
            writer.println("Tarea 1,false");
            writer.println("Tarea 2,false");
            writer.close();

            // Simular entrada del usuario
            ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
            System.setIn(in);
            Scanner scanner = new Scanner(in);

            // Ejecutar método marcarTareaComoCompletada
            Tarea.marcarTareaComoCompletada(scanner);

            // Verificar que la tarea se marcó como completada en el archivo
            File file = new File("tareas.txt");
            Scanner fileScanner = new Scanner(file);
            String line = fileScanner.nextLine();
            assertTrue(line.endsWith("true"));

            // Limpiar archivo para próximas pruebas
            PrintWriter cleanWriter = new PrintWriter("tareas.txt");
            cleanWriter.close();
        } catch (IOException e) {
            fail("Error: " + e.getMessage());
        }
    }

    @Test
    public void testEliminarTareas() {
        try {
            // Limpiar archivo para prueba
            PrintWriter writer = new PrintWriter("tareas.txt");
            writer.println("Tarea 1,false");
            writer.println("Tarea 2,false");
            writer.close();

            // Simular entrada del usuario
            ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
            System.setIn(in);
            Scanner scanner = new Scanner(in);

            // Ejecutar método eliminarTareas
            Tarea.eliminarTareas(scanner);

            // Verificar que la tarea se eliminó del archivo
            File file = new File("tareas.txt");
            Scanner fileScanner = new Scanner(file);
            int lineCount = 0;
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                lineCount++;
            }
            assertEquals(1, lineCount);

            // Limpiar archivo para próximas pruebas
            PrintWriter cleanWriter = new PrintWriter("tareas.txt");
            cleanWriter.close();
        } catch (IOException e) {
            fail("Error: " + e.getMessage());
        }
    }


<<<<<<< HEAD
}
=======
}
>>>>>>> d4b8c5b790182adcac5bb35772ad573b1a43cb97
