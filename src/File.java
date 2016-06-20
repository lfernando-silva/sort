import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Luiz on 19/06/2016.
 */
public class File {

    LinkedList<Integer> dados = new LinkedList<>();

    public int[] ler(String file) throws Exception{
        FileReader fr = new FileReader(file);
        Scanner leitor = new Scanner(fr).useDelimiter("\\,|\\n");

        while(leitor.hasNext()){
            String data = leitor.next();
            dados.add(Integer.parseInt(data));
        }
        return dados.stream().mapToInt(i->i).toArray(); //Retorna um array de inteiros a partir de uma linkedlist;
    }
}
