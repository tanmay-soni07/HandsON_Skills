import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {

        int result = calculator.add(10, 20);

        assertEquals(30, result);
    }

    @Test
    public void testSubtraction() {

        int result = calculator.subtract(20, 10);

        assertEquals(10, result);
    }
}