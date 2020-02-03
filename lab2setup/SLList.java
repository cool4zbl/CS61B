/**
 * An SLList is a list of integers.
 */

public class SLList {
    public IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /**
     * Adds x to the front of the list
     */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        int a = L.getFirst();
        System.out.println(a);
    }

}
