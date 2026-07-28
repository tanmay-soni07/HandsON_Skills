import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    void testSpy() {

        Calculator calculator = new Calculator();

        Calculator spyCalculator = spy(calculator);

        assertEquals(30, spyCalculator.add(10, 20));

        doReturn(100).when(spyCalculator).multiply(5, 5);

        assertEquals(100, spyCalculator.multiply(5, 5));

    }

}