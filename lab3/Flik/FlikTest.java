import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlikTest {

    @Test
    public void testIsSameNumber() {
        assertTrue(Flik.isSameNumber(3, 3));
        assertTrue(Flik.isSameNumber(12, 12));
        assertTrue(Flik.isSameNumber(100, 100));
        assertTrue(Flik.isSameNumber(127, 127));
        assertTrue(Flik.isSameNumber(128, 128));
        assertTrue(Flik.isSameNumber(130, 130));
    }

}
