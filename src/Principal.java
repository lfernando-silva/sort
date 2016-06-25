/**
 * Created by Luiz on 19/06/2016.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        boolean menu = true;

        File f = new File();
        int[] desordenado = f.ler("./dados/dados.txt");
        while (menu) {
            System.out.println("Escolha a opção");
            System.out.println("1. Ordenação MergeSort");
            System.out.println("2. Ordenação QuickSort");
            System.out.println("3. Ordenação HeapSort");
            System.out.println("9. Sair");
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Dados originais:");
                    imprime(desordenado);
                    System.out.println("Dados ordenados por MergeSort:");
                    int[] ordenado = MergeSort.sort(desordenado);
                    imprime(ordenado);
                    boolean isOrdenado = MergeSort.checaOrdenacao(ordenado);
                    System.out.println(confirmaOrdenacao(isOrdenado));
                }
                break;
                case 2: {
                    System.out.println("Dados originais:");
                    imprime(desordenado);
                    System.out.println("Dados ordenados por QuickSort:");
                    int[] ordenado = QuickSort.sort(desordenado);
                    imprime(ordenado);
                    boolean isOrdenado = QuickSort.checaOrdenacao(ordenado);
                    System.out.println(confirmaOrdenacao(isOrdenado));
                }
                break;
                case 3: {
                    System.out.println("Dados originais:");
                    imprime(desordenado);
                    System.out.println("Dados ordenados por HeapSort:");
                    int[] ordenado = HeapSort.sort(desordenado, desordenado.length);
                    imprime(ordenado);
                    boolean isOrdenado = HeapSort.checaOrdenacao(ordenado);
                    System.out.println(confirmaOrdenacao(isOrdenado));
                }
                break;
                case 9: {
                    System.out.println("Tchau!");
                    menu = !menu;
                }break;
                default: {
                    System.out.println("Opção inválida!");
                }
                break;
            }
        }
    }

    public static void imprime(int[] lista){
        System.out.println(Arrays.toString(lista));
    }

    public static String confirmaOrdenacao(boolean isOrdenado){
        if(isOrdenado) return "Lista ordenada";
        return "Lista não ordenada!";
    }

}
