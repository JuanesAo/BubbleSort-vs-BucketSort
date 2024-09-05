import java.util.List;

public class BubbleSort {
    public static void bubbleSort(List<String> lista) {
        int n = lista.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (lista.get(j).compareTo(lista.get(j+1)) > 0) {
                    // Intercambiar elementos
                    String temp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, temp);
                }
            }
        }
    }
}
