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

    private int originalSize = 8;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[originalSize];
        nextFirst = 0;
        nextLast = 1;
    }

    /**
     * Creates a deep copy of other
     */
//    public ArrayDeque(ArrayDeque other) {
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i));
//        }
//    }

    // TODO: resizing at `nextLast` == item.length - 1
    private void resize() {
        // nextLast 距离 nextFirst 只差一个位置 || nextFirst 距离当前数组最末端只差一个位置
//        if (nextFirst == pulsOne(nextLast) || minusOne(nextFirst) == items.length - 1) {
        if (nextFirst == nextLast
                || nextFirst == items.length - 1
//                || nextLast == items.length - 1
        ) {
            int capacity = items.length * 2;
            T[] a = (T[]) new Object[capacity];
            System.arraycopy(items, pulsOne(nextFirst),
                    a, a.length / originalSize, size);
            items = a;
            nextFirst = minusOne(a.length / originalSize);
            nextLast = a.length / originalSize + size;
        }
    }

    /**
     * computed the index immediately "before" a given index.
     *
     * @param index
     * @return int index
     */
    private int minusOne(int index) {
        return ((index - 1) + items.length) % items.length;
    }

    /**
     * computed the index immediately "after" a given index.
     *
     * @param index
     * @return int index
     */
    private int pulsOne(int index) {
        return (index + 1) % items.length;
    }


    /**
     * Adds an item of type `T` to the front of the deque.
     *
     * @param item
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
        resize();
    }

    /**
     * Adds an item of type `T` to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
        items[nextLast] = item;
        size++;
        nextLast = pulsOne(nextLast);
        resize();
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

        // resize();
        nextFirst = pulsOne(nextFirst);
        T item = items[nextFirst];
        size--;
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

        nextLast = minusOne(nextLast);
        T item = items[nextLast];
        size--;
        return item;
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
        if (index < 0 || index >= size) {
            return null;
        }
        return items[index];
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

    public int size() {
        return size;
    }
}
