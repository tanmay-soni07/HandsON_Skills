import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    EvenChecker checker = new EvenChecker();

    @Test
    void testEven() {

        assertTrue(checker.isEven(8));

    }

}