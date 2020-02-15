/**
 * An SLList is a list of integers.
 */

public class SLList<Loch> {
    public class StuffNode {
        public Loch item;
        public StuffNode next;

        public StuffNode(Loch i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private StuffNode last;

    private int size;

    public SLList(Loch x) {
        sentinel = new StuffNode(x, null);
        sentinel.next = new StuffNode(x, null);
        last = sentinel.next;
        size = 1;
    }

//    public SLList() {
//        sentinel = new StuffNode(2, null);
//        size = 0;
//    }

    /**
     * Adds x to the front of the list
     */
    public void addFirst(Loch x) {
        size += 1;
        sentinel.next = new StuffNode(x, sentinel.next);
    }

    public Loch getFirst() {
        return sentinel.next.item;
    }

    public void deleteFirst() {
        StuffNode p = sentinel.next;

        if (p != null) {
            size -= 1;
            sentinel.next = p.next;
        }
    }

    public void addLast(Loch x) {
        size += 1;

        last.next = new StuffNode(x, null);
        last = last.next;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(15);

        L.addFirst(10);
        L.addFirst(5);
        L.addLast(3);
        int size = L.size();
        System.out.println(L.getFirst());
        System.out.println(size);

        L.deleteFirst();
        System.out.println(L.size());
        System.out.println(L.getFirst());

        SLList<String> Q = new SLList<>("hi");
        Q.deleteFirst();
        Q.addLast("world");

        System.out.println(Q.size());
    }
}
