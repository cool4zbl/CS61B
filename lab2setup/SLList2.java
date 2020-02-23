/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList2<LochNess> {
    private class StuffNode {
        public LochNess item;
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private StuffNode first;
    private int size;

    public SLList2(LochNess x) {
        first = new StuffNode(x, null);
        size = 1;
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(LochNess x) {
        first = new StuffNode(x, first);
        size += 1;
    }

    /**
     * Returns the first item in the list.
     */
    public LochNess getFirst() {
        return first.item;
    }

    /**
     * Adds an item to the end of the list.
     */
    public void addLast(LochNess x) {
        size += 1;

        StuffNode p = first;

        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new StuffNode(x, null);
    }

    public int size() {
        return size;
    }

    public void reverse() {
        if (first == null || first.next == null) {
            return;
        }

        StuffNode p = first.next;
        first.next = null;

        while (p.next != null) {
            StuffNode temp = p.next;
            p.next = first;
            first = p;
            p = temp;
        }
        p.next = first;
        first = p;
    }

    public void reverseRecur() {
        first = reverseHelper(first);
    }

    public StuffNode reverseHelper(StuffNode lst) {
        if (lst == null || lst.next == null) return lst;
        StuffNode endOfReversed = lst.next;
        StuffNode reversed = reverseHelper(lst.next);
        endOfReversed.next = lst;
        lst.next = null;
        return reversed;
    }

    public static void main(String[] args) {
        SLList2<Integer> L = new SLList2<>(15);

        L.addFirst(10);
        L.addLast(5);
        L.addLast(20);
        L.reverseRecur();
        System.out.println(L.getFirst());
    }
}
