/**
 * Created by Luiz on 19/06/2016.
 */
public class MergeSort {

    private static int[] auxiliar;

    public static int[] sort(int[] lista) {
        auxiliar = new int[lista.length];
        sort(lista, 0, lista.length - 1);
        return lista;
    }

    private static void sort(int[] lista, int start, int length) {
        if (length <= start) return;
        int pivo = start + (length - start) / 2;
        sort(lista, start, pivo);
        sort(lista, pivo + 1, length);
        merge(lista, start, pivo, length);
    }

    public static void merge(int[] lista, int start, int pivo, int length) {
        int i = start;
        int j = pivo + 1;
        for (int k = start; k <= length; k++)
            auxiliar[k] = lista[k];
        for (int k = start; k <= length; k++)
            if (i > pivo) lista[k] = auxiliar[j++];
            else if (j > length) lista[k] = auxiliar[i++];
            else if (auxiliar[j] < auxiliar[i]) lista[k] = auxiliar[j++];
            else lista[k] = auxiliar[i++];
    }

    private static void troca(int[] lista, int i, int j) {
        int t = lista[i];
        lista[i] = lista[j];
        lista[j] = t;
    }

    public static boolean checaOrdenacao(int[] lista) {
        int length = lista.length;
        for (int i = 0; i < length - 1; i++) {
            if (lista[i] > lista[i + 1]) return false;
        }
        return true;
    }
}
