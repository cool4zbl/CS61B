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
//    public ArrayDeque(ArrayDeque other) {
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i));
//        }
//    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /**
     * Adds an item of type `T` to the front of the deque.
     *
     * @param item
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst--;
        }
    }

    /**
     * Adds an item of type `T` to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
        items[nextLast] = item;
        size++;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     *
     * @return T
     */
    public T removeFirst() {
        T item = items[nextFirst];

        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
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
        T item = items[nextLast];
        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast--;
        }
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
        if (index < 0 || index >= size) return null;
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

    public int getNextFirst() {
        return nextFirst;
    }

    public int getNextLast() {
        return nextLast;
    }
}
