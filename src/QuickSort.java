/**
 * Created by Luiz on 19/06/2016.
 */
public class QuickSort {
    public static int[] sort(int[] lista) {
        sort(lista,0,lista.length-1);
        return lista;
    }

    private static boolean sort(int[] lista, int inicio, int fim){
        if(fim <= inicio) return false;
        int particao = particiona(lista,inicio,fim);
        sort(lista,inicio,particao-1);
        sort(lista,particao+1,fim);
        return true;
    }

    private static int particiona(int[] lista, int inicio, int fim){
        int i = inicio;
        int j = fim + 1;
        int length = lista.length;
        //int pivo = lista[0] + lista[(length+1)/2] + lista[length-1]; //não funciona, faz o scan pra direita não acontecer
        int pivo = lista[inicio];
        while(true){
            while(lista[++i] > pivo) if(i == fim) break;
            while(pivo > lista[--j]) if(j == inicio) break;
            if(i > j) break;
            troca(lista,i,j);
        }
        troca(lista,inicio,j);
        return j;
    }

    private static void troca(int[] lista, int i, int j)
    {
        int trocavel = lista[i];
        lista[i] = lista[j];
        lista[j] = trocavel;
    }
}
