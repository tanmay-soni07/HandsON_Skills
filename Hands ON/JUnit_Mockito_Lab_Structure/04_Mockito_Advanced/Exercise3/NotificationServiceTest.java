import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    void testDoAnswer() {

        MessageService service = mock(MessageService.class);

        doAnswer(invocation -> {

            String message = invocation.getArgument(0);

            System.out.println("Mocked Message: " + message);

            return null;

        }).when(service).sendMessage(anyString());

        NotificationService notification =
                new NotificationService(service);

        notification.notifyUser("Hello Tanmay");

        verify(service).sendMessage("Hello Tanmay");

    }

}