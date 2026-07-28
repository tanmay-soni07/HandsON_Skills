import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5, 2 + 3);

        // Assert True
        assertTrue(10 > 5);

        // Assert False
        assertFalse(5 > 10);

        // Assert Null
        String name = null;
        assertNull(name);

        // Assert Not Null
        Object obj = new Object();
        assertNotNull(obj);

    }
}