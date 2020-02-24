import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(1, L.size());
    }
}
