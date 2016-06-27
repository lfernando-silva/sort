/**
 * Created by Luiz on 19/06/2016.
 */

import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;

public class Principal {

   public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        boolean menu = true;

        File f = new File();
        int[] desordenado = f.ler("./dados/dados_ordenados_decrescente.txt");
        while (menu) {

            int[] ordenado = null;
            System.gc();

            System.out.println("Escolha a opção");
            System.out.println("1. Ordenação MergeSort");
            System.out.println("2. Ordenação QuickSort");
            System.out.println("3. Ordenação HeapSort");
            System.out.println("9. Sair");
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1: {
                    imprimeDesordenado(desordenado);
                    System.out.println("Dados ordenados por MergeSort:");
                    ordenado = MergeSort.sort(desordenado);
                    imprimeOrdenado(ordenado,new Date(),MergeSort.checaOrdenacao(ordenado));
                }
                break;
                case 2: {
                    imprimeDesordenado(desordenado);
                    System.out.println("Dados ordenados por QuickSort:");
                    ordenado = QuickSort.sort(desordenado);
                    imprimeOrdenado(ordenado,new Date(),QuickSort.checaOrdenacao(ordenado));
                }
                break;
                case 3: {
                    imprimeDesordenado(desordenado);
                    System.out.println("Dados ordenados por HeapSort:");
                    ordenado = HeapSort.sort(desordenado,desordenado.length);
                    imprimeOrdenado(ordenado,new Date(),HeapSort.checaOrdenacao(ordenado));
                }
                break;
                case 9: {
                    System.out.println("Tchau!");
                    menu = !menu;
                }
                break;
                default: {
                    System.out.println("Opção inválida!");
                }
                break;
            }
        }
    }

    public static void imprimeDesordenado(int[] lista){
        System.out.println("Dados originais:");
        System.out.println(Arrays.toString(lista));
    }

    public static void imprimeOrdenado(int[] lista, Date d, boolean isOrdenado) {
        System.out.println(Arrays.toString(lista));
        long diff = new Date().getTime() - d.getTime();
        System.out.println("Ordenado em " + diff + " ms");
        System.out.println(confirmaOrdenacao(isOrdenado));
        System.out.println("Memória usada:"+getUsedMemory());
    }

    public static long getUsedMemory(){
        Runtime r = Runtime.getRuntime();
        return r.totalMemory() - r.freeMemory(); //Mb
    }

    public static String confirmaOrdenacao(boolean isOrdenado) {
        if (isOrdenado) return "Lista ordenada";
        return "Lista não ordenada!";
    }
}
