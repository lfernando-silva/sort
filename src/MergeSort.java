/**
 * Created by Luiz on 19/06/2016.
 */
public class MergeSort {
    private static int[] aux;

    public static int[] sort(int[] lista) {

        int length = lista.length;
        aux = new int[length];
        sort(lista, 0, length - 1);
        return lista;
    }

    private static boolean sort(int[] lista, int inicio, int fim) {
        if (fim <= inicio) return false;

        int pivo = inicio + (fim - inicio) / 2;

        sort(lista, inicio, pivo);
        sort(lista, pivo + 1, fim);
        merge(lista, inicio, pivo, fim);
        return true;
    }

    public static void merge(int[] lista, int inicio, int pivo, int fim) {
        int i = inicio, j = pivo + 1;

        for (int f = inicio; f <= fim; f++) {
            aux[f] = lista[f];
        }

        for (int f = inicio; f <= fim; f++) {
            if (i > pivo) lista[f] = aux[j++];
            else if (j > fim) lista[f] = aux[i++];
            else if (aux[j] > aux[i]) lista[f] = aux[j++];
            else lista[f] = aux[i++];
        }
    }
}
