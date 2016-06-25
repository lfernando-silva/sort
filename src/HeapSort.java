/**
 * Created by Luiz on 19/06/2016.
 */
public class HeapSort {

    public static void buildHeap(int[] lista, int length, int k) {
        int j, valor;
        valor = lista[k];
        while (k < length / 2) {
            j = 2 * k + 1;
            if (j < length - 1 && lista[j] < lista[j + 1]) j++;
            if (valor >= lista[j]) break;
            lista[k] = lista[j];
            k = j;
        }
        lista[k] = valor;
    }

    public static int[] sort(int[] lista, int length) {
        int indice, troca;
        for (indice = length / 2; indice >= 0; indice--) buildHeap(lista, length, indice);
        while (length > 0) {
            troca = lista[0];
            lista[0] = lista[length - 1];
            lista[length - 1] = troca;
            buildHeap(lista, --length, 0);
        }
        return lista;
    }

    public static boolean checaOrdenacao(int[] lista){
        int length = lista.length;
        for(int i = 0; i < length-1; i++){
            if(lista[i] > lista[i+1]) return false;
        }
        return true;
    }

}

