/**
 * Created by Luiz on 19/06/2016.
 */
public class QuickSort {

    public static int[] sort(int[] lista) {
        sort(lista, 0, lista.length - 1);
        return lista;
    }

    private static void sort(int[] lista, int start, int length) {
        if (length <= start) return;
        int j = particiona(lista, start, length);
        sort(lista, start, j - 1);
        sort(lista, j + 1, length);
    }

    private static int particiona(int[] lista, int start, int length) {
        int i = start;
        int j = length + 1;
        int pivo = lista[start];
        while (true) {
            while (lista[++i] < pivo) if (i == length) break;
            while (pivo < lista[--j]) if (j == start) break;
            if (i >= j) break;
            troca(lista, i, j);
        }
        troca(lista, start, j);
        return j;
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
