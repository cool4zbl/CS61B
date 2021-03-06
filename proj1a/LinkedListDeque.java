/**
 * LinkedListDeque
 *
 * @author blz
 * @see https://sp19.datastructur.es/materials/proj/proj1a/proj1a
 * @since 2020-02-15
 */
public class LinkedListDeque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        private StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Creates a deep copy of `other`
     * if you change `other`, the new `LinkedListDeque` should not change as well.
     * doesn't exists at sp18 proj https://sp18.datastructur.es/
     *
     * @param other
     */
//    public LinkedListDeque(LinkedListDeque other) {
//        sentinel = new StuffNode(null, null, null);
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//        size = 0;
//
//        /* Method 1
//        StuffNode p = other.sentinel.next;
//        while (p != other.sentinel) {
//            size += 1;
//            sentinel.prev.next =
//                 new StuffNode(sentinel.prev, p.item, sentinel);
//            sentinel.prev = sentinel.prev.next;
//            p = p.next;
//        }
//         */
//
//        /* Method 2 */
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i));
//        }
//    }

    /**
     * Adds an item of type `T` to the front of the deque.
     *
     * @param item
     */
    public void addFirst(T item) {
        size += 1;

        sentinel.next.prev =
                new StuffNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
    }

    /**
     * Adds an item of type `T` to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
        size += 1;

        sentinel.prev.next =
                new StuffNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
    }

    /**
     * returns true if deque is empty, false otherwise.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns the number of items in the deque
     * at constant time
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last,
     * separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int count = 0;
        StuffNode cur = sentinel.next;
        while (count++ < size) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @return T
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        StuffNode first = sentinel.next;
        T item = first.item;
        sentinel.next = first.next;
        sentinel.next.prev = sentinel;
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @return T
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        StuffNode last = sentinel.prev;
        sentinel.prev = last.prev;
        sentinel.prev.next = sentinel;
        return last.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     * Use `iteration`
     *
     * @param index
     * @return T
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int count = 0;
        StuffNode find = sentinel.next;
        while (count++ < index) {
            find = find.next;
        }
        return find.item;
    }

    private T traverse(int index, StuffNode L) {
        if (index == 0) {
            return L.item;
        }
        return traverse(index - 1, L.next);
    }

    /**
     * Same as get, but uses recursion.
     *
     * @param index
     * @return T
     */
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        return traverse(index, sentinel.next);
    }
}
