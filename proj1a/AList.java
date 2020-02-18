/**
 * Array based list.
 *
 * @author blz
 */

public class AList {
    private int size;
    private int[] items;

    /**
     * Creates an empty list.
     */
    public AList() {
        size = 0;
    }

    public AList(int s) {
        size = s;
        items = new int[s];
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        int[] newItems = new int[size + 1];
        if (size > 1) {
            System.arraycopy(items, 0, newItems, 0, size);
        }
        items = newItems;
        items[size] = x;
        size += 1;
    }

    /**
     * Returns the item from the back of the list.
     */
    public int getLast() {
        return items[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        if (i < 0 || i >= size) throw new ArrayIndexOutOfBoundsException("out of size");

        return items[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public int removeLast() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Out of range");

        int last = items[size - 1];
        size -= 1;
        int[] newItems = new int[size];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        return last;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
