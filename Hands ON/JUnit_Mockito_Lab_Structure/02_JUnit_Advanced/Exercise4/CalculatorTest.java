import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testDivide() {

        assertEquals(5, calculator.divide(10, 2));

    }

    @Test
    void testDivideByZero() {

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });

    }

}