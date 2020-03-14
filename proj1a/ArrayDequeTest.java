import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for ArrayDeque.
 *
 * @author blz
 */
public class ArrayDequeTest {

    @Test
    public void testEmptySize() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        assertEquals(0, L.size());
        assertTrue(L.isEmpty());
    }

    @Test
    public void testAddLastAndSize() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("a");
        L.addLast("b");
        L.addLast("d");
        L.addLast("e");
        // "a" -> "b" -> "d" -> "e"
        assertEquals(4, L.size());
//        assertEquals("a", L.get(L.getNextFirst() + 1));
//        assertEquals("b", L.get(L.getNextFirst() + 2));
    }

    @Test
    public void testAddFirstAndSize() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("e");
        L.addFirst("d");
        L.addFirst("b");
        L.addFirst("a");
        // "a" -> "b" -> "d" -> "e"
        assertEquals(4, L.size());
    }

    @Test
    public void testAddFirstAndNextLast() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("a");
        L.addLast("b");
        L.addFirst("c");
        L.addLast("d");
        L.addLast("e");
        L.addFirst("f");
        assertEquals(6, L.size());
        L.printDeque();
    }

    @Test
    public void testRemoveLastAndSize() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("a");
        L.addFirst("b");
        L.addLast("c");
        L.addFirst("d");
        // "d" -> "b" -> "a" -> "c"
        String last = L.removeLast();
        assertEquals(3, L.size());
        assertEquals(last, "c");
        String last1 = L.removeLast();
        assertEquals(2, L.size());
        assertEquals(last1, "a");

        String last2 = L.removeLast();
        assertEquals(1, L.size());
        assertEquals(last2, "b");

        String last3 = L.removeLast();
        assertEquals(0, L.size());
        assertEquals(last3, "d");
    }

    @Test
    public void testRemoveFirstAndSize() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addLast("a");
        L.addFirst("b");
        L.addLast("c");
        L.addFirst("d");
        // "d" -> "b" -> "a" -> "c"
        String first0 = L.removeFirst();
        assertEquals(3, L.size());
        assertEquals(first0, "d");
        String first1 = L.removeFirst();
        assertEquals(2, L.size());
        assertEquals(first1, "b");

        String first2 = L.removeFirst();
        assertEquals(first2, "a");
        assertEquals(1, L.size());

        String first3 = L.removeFirst();
        assertEquals(first3, "c");
        assertEquals(0, L.size());
    }

    @Test
    public void testRemoveFromEmptyDeque() {
        ArrayDeque<String> L = new ArrayDeque<>();
        assertEquals(0, L.size());
        String a = L.removeLast();

        assertNull(a);
        assertEquals(0, L.size());

        String b = L.removeFirst();
        assertNull(b);
        assertEquals(0, L.size());

    }


    /**
     * Tests insertion of a large number of items.
     */
    @Test
    public void testMegaInsert() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }

    /**
     * Tests insertion of a large number of items, then remove.
     */
    @Test
    public void testMegaInsertAndRemove() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 100000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }
        assertEquals(N, L.size());

        for (int i = 0; i < N - 10; i += 1) {
            L.removeLast();
        }
        assertEquals(10, L.size());
        System.out.println(L.size());
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
