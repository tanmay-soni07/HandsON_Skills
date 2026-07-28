import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    void testArgumentCaptor() {

        EmailService emailService = mock(EmailService.class);

        NotificationService service =
                new NotificationService(emailService);

        service.sendWelcomeEmail("Tanmay");

        ArgumentCaptor<String> captor =
                ArgumentCaptor.forClass(String.class);

        verify(emailService).sendEmail(captor.capture());

        assertEquals("Welcome Tanmay", captor.getValue());

    }

}