import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(15, calculator.add(10, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
    }

}