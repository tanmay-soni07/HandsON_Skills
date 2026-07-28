import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationManagerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificationManager manager;

    @Test
    void testNotifyUser() {

        manager.notifyUser("Welcome Tanmay");

        verify(emailService).sendEmail("Welcome Tanmay");

    }

}