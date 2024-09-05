import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {
    public static List<String> leerPalabras(String rutaArchivo) {
        // Inicializa una lista vacía para almacenar las palabras
        List<String> palabras = new ArrayList<>();

        // Intenta abrir el archivo en la ruta especificada
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Lee cada línea del archivo hasta que no haya más líneas
            while ((linea = br.readLine()) != null) {
                // Añade la línea leída a la lista de palabras
                palabras.add(linea);
            }
        } catch (IOException e) {
            // Imprime la traza de la pila si ocurre una excepción al leer el archivo
            e.printStackTrace();
        }

        // Devuelve la lista de palabras
        return palabras;
    }
}

