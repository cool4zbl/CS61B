import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Performs some basic linked list tests.
 */
public class LinkedListDequeTest {

    @Test
    public void testEmptySize() {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        assertEquals(0, L.size());
        assertTrue(L.isEmpty());
    }

    /**
     * Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * <p>
     * && is the "and" operation.
     */
    @Test
    public void testAddIsEmptySizeTest() {
        LinkedListDeque<String> L = new LinkedListDeque<String>();

        assertTrue(L.isEmpty());

        L.addFirst("front");

        assertEquals(1, L.size());

        L.addLast("middle");
        L.addLast("back");
        L.addFirst("end");
        assertEquals(4, L.size());

    }

    /**
     * Adds an item, then removes an item, and ensures that dll is empty afterwards.
     */
    @Test
    public void testAddRemoveTest() {

        System.out.println("Running add/remove test.");

		/*
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		*/

        LinkedListDeque<Integer> L = new LinkedListDeque<>();

        L.addFirst(10);
        L.addFirst(20);
        L.addFirst(21);
        L.addLast(20);
        assertEquals(4, L.size());

        int a = L.removeFirst();
        assertEquals(21, a);

        int b = L.removeFirst();
        assertEquals(20, b);
        b = L.removeFirst();
        assertEquals(10, b);
        b = L.removeLast();
        assertEquals(20, b);
        assertEquals(0, L.size());
        assertTrue(L.isEmpty());

    }

    @Test
    public void getItemTest() {
        System.out.println("Running getItem test.");

        LinkedListDeque<String> lld2 = new LinkedListDeque<>();

        lld2.addFirst("wa");
        lld2.addLast("wow");
        lld2.addLast("hei");

        lld2.addFirst("yoy");
        assertEquals("wa", lld2.getRecursive(1));
        assertEquals("wow", lld2.get(2));
        assertEquals(null, lld2.get(5));

    }

    /*
    @Test
    public void deepCopyTest() {
        System.out.println("Running deepCopy test.");

        LinkedListDeque<String> lld2 = new LinkedListDeque<>();

        lld2.addFirst("Hello");
        lld2.addLast("World");

        LinkedListDeque<String> lld3 = new LinkedListDeque<>();
        lld2.addFirst("Yoy");

        System.out.println("Printing out deque: ");
        lld2.printDeque();
        lld3.printDeque();
    }
     */

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        jh61b.junit.TestRunner.runTests("all", LinkedListDequeTest.class);
    }
}
