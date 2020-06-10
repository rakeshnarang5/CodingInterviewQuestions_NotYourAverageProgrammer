import java.util.*;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Node start = new Node(10);
        start.next = new Node(20);
        start.next.next = new Node(30);
        start.next.next.next = new Node(40);
        Node init = start;
        List < Integer > val = new ArrayList < > ();
        int i = 0;
        while (init != null) {
            val.add(init.data);
            i++;
            init = init.next;
        }
        System.out.println(val.get(i - 2));
    }

}
