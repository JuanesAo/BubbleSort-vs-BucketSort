import java.util.List;
import java.util.ArrayList;

public class MedicionTiempo {
    public static void main(String[] args) {
        try {
            // Define la ruta del archivo a leer
            String rutaArchivo = "C:\\JavaProyects\\Medicion\\palabras.es";
            System.out.println("Leyendo archivo desde: " + rutaArchivo);

            // Lee las palabras del archivo y las almacena en una lista
            List<String> palabras = LeerArchivo.leerPalabras(rutaArchivo);
            System.out.println("Total de palabras leídas: " + palabras.size());

            // Define los tamaños de las subListas a ordenar
            int[] tamanos = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 110000, 120000, 130000, 140000, 150000, 160000, 170000, 180000, 190000, 200000, 210000, 220000, 230000, 240000, 247047};

            // Para cada tamaño definido
            for (int tamano : tamanos) {
                // Si no hay suficientes palabras, imprime un mensaje y pasa al siguiente tamaño
                if (palabras.size() < tamano) {
                    System.out.println("No hay suficientes palabras para probar con " + tamano + " palabras.");
                    continue;
                }

                // Crea una subLista de palabras del tamaño especificado
                List<String> subLista = palabras.subList(0, tamano);
                System.out.println("Número de palabras en subLista: " + subLista.size());

                // Crea una copia de la subLista para ordenar con Bubble Sort
                List<String> listaBubbleSort = new ArrayList<>(subLista);
                // Registra el tiempo de inicio
                long inicioBubble = System.nanoTime();
                System.out.println("Iniciando Bubble Sort para " + tamano + " palabras...");
                // Ordena la lista con Bubble Sort
                BubbleSort.bubbleSort(listaBubbleSort);
                // Registra el tiempo de finalización y calcula el tiempo total
                long finBubble = System.nanoTime();
                long tiempoBubbleSort = finBubble - inicioBubble;

                // Crea una copia de la subLista para ordenar con Bucket Sort
                List<String> listaBucketSort = new ArrayList<>(subLista);
                // Registra el tiempo de inicio
                long inicioBucket = System.nanoTime();
                System.out.println("Iniciando Bucket Sort para " + tamano + " palabras...");
                // Ordena la lista con Bucket Sort, utilizando 10 buckets
                BucketSort.bucketSort(listaBucketSort, 10);
                // Registra el tiempo de finalización y calcula el tiempo total
                long finBucket = System.nanoTime();
                long tiempoBucketSort = finBucket - inicioBucket;

                // Imprime los resultados
                System.out.println("Datos: " + tamano + ", Tiempo BubbleSort: " + tiempoBubbleSort + " ns, Tiempo BucketSort: " + tiempoBucketSort + " ns");
            }
        } catch (Exception e) {
            // Imprime la traza de la pila si ocurre una excepción
            e.printStackTrace();
        }
    }
}