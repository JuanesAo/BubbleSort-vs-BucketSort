import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void bucketSort(List<String> lista, int numBuckets) {
        // Crear buckets
        ArrayList<ArrayList<String>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>()); // Inicializar cada bucket como una lista vacía
        }

        // Distribuir elementos en los buckets
        for (String palabra : lista) {
            int bucketIndex = getBucketIndex(palabra, numBuckets); // Obtener el índice del bucket para la palabra
            buckets.get(bucketIndex).add(palabra); // Añadir la palabra al bucket correspondiente
        }

        // Ordenar cada bucket y concatenar resultados
        int index = 0;
        for (ArrayList<String> bucket : buckets) {
            Collections.sort(bucket); // Ordenar cada bucket individualmente
            for (String palabra : bucket) {
                lista.set(index++, palabra); // Añadir las palabras ordenadas de vuelta a la lista original
            }
        }
    }

    private static int getBucketIndex(String palabra, int numBuckets) {
        char firstChar = Character.toLowerCase(palabra.charAt(0)); // Convertir a minúscula para uniformidad
        if (firstChar < 'a' || firstChar > 'z') {
            // Si el carácter no es una letra entre 'a' y 'z', asignarlo al último bucket
            return numBuckets - 1;
        }
        // Calcular el índice del bucket basado en el primer carácter de la palabra
        // Esto distribuye las palabras de manera uniforme entre los buckets
        return (firstChar - 'a') * numBuckets / 26;
    }
}

