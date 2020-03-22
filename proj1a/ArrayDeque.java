/**
 * ArrayDeque
 *
 * @author blz
 * @created 2020-02-24
 * @updated 2020-03-22
 */
public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    private int originalSize = 4;

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
    private void generate(int capacity, int newFirst) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, plusOne(nextFirst),
                a, plusOne(newFirst), size);

        items = a;
        nextFirst = newFirst;
        nextLast = plusOne(nextFirst) + size;
    }

    /**
     * Resize when usage ratio < 0.25
     */
    private void resize(int currentSize, int itemsLength) {
        if (4 * currentSize < itemsLength) {
            int capacity = items.length / 2;
//            int newFirst = nextFirst - capacity / originalSize;
            int newFirst = nextFirst / 2;
            generate(capacity, newFirst);
        }
    }

    /**
     * Rules: 1. nextFirst & nextLast 指向下一个可用的 index.
     * 2. nextFirst 总是比 nextLast 小
     * 3. nextLast = plusOne(nextFirst) + size
     * <p>
     * Resize:
     * 0. resize 在任何添加之前 || 任何删除之后？
     * 1. nextFirst 距离当前数组最末端只差一个位置
     * 2. minusOne(nextFirst) == items.length - 1
     * 3. plusOne(nextLast) == items.length - 1
     */
    private void resize() {
        if (minusOne(nextFirst) == items.length - 1
                || nextLast == items.length - 1
        ) {

            int capacity = items.length * 2;
            int newFirst = nextFirst + capacity / originalSize;
            generate(capacity, newFirst);
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
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }


    /**
     * Adds an item of type `T` to the front of the deque.
     *
     * @param item
     */
    public void addFirst(T item) {
        resize();
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    /**
     * Adds an item of type `T` to the back of the deque.
     *
     * @param item
     */
    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
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

        nextFirst = plusOne(nextFirst);
        T item = items[nextFirst];
        size--;

//        resize(size, items.length);

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

//        resize(size, items.length);

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
        for (int i = plusOne(nextFirst); i < nextLast; i++) {
            System.out.println(items[i]);
        }
    }

    public int size() {
        return size;
    }
}
