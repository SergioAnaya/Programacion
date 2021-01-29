import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IntroLinkedList {

    public void recorrer (List<Integer> lista) {
        Iterator<Integer> it = lista.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
     }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        IntroLinkedList recorrido = new IntroLinkedList();

        recorrido.recorrer(linkedList);
        recorrido.recorrer(arrayList);

    }

}
