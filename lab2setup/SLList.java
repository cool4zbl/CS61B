/**
 * An SLList is a list of integers.
 */

public class SLList {
    private IntNode sentinel;

    private int size;

    public SLList(int x) {
        sentinel = new IntNode(22, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(22, null);
        size = 0;
    }

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /**
     * Adds x to the front of the list
     */
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);

        L.addFirst(10);
        L.addFirst(5);
        L.addLast(3);
        int a = L.getFirst();
        int size = L.size();
        System.out.println(a);
        System.out.println(size);

        SLList Q = new SLList();
        Q.addLast(4);
        System.out.println(Q.size());
    }
}
