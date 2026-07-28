import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Test
    void testPaymentException() {

        PaymentGateway gateway = mock(PaymentGateway.class);

        doThrow(new RuntimeException("Payment Failed"))
                .when(gateway)
                .processPayment(1000);

        PaymentService service = new PaymentService(gateway);

        RuntimeException exception =
                assertThrows(RuntimeException.class, () -> {
                    service.makePayment(1000);
                });

        assertEquals("Payment Failed", exception.getMessage());

    }

}