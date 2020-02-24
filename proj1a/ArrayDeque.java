/**
 * ArrayDeque
 *
 * @author blz
 * @date 2020-02-24
 */
public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * Creates a deep copy of other
     */
    public ArrayDeque(ArrayDeque other) {
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

//    private void resize(int capacity) {
//        T[] a = (T[]) new Object[capacity];
//        System.arraycopy(items, 0, a, 0, size);
//        items = a;
//    }

    /**
     * Adds an item of type `T` to the front of the deque.
     *
     * @param item
     */
    public void addFirst(T item) {
    }

    /**
     * Adds an item of type `T` to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
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
     * Prints the items in the deque from first to last,
     * separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @return T
     */
    public T removeFirst() {
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     *
     * @return T
     */
    public T removeLast() {
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
        if (index < 0 || index >= size) return null;
        return items[index];
    }

    private T traverse(T[] arr, int index) {

    }

    /**
     * Same as get, but uses recursion.
     *
     * @param index
     * @return T
     */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) return null;
        return traverse(items, index);
    }

    public int size() {
        return size;
    }
}
