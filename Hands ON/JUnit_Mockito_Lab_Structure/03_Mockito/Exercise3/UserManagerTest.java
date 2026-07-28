import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserManagerTest {

    @Test
    void testNotificationSent() {

        NotificationService service =
                mock(NotificationService.class);

        UserManager manager =
                new UserManager(service);

        manager.registerUser("Tanmay");

        verify(service).sendNotification("Welcome Tanmay");

    }

    @Test
    void testNotificationCalledTwice() {

        NotificationService service =
                mock(NotificationService.class);

        UserManager manager =
                new UserManager(service);

        manager.registerUser("Amit");
        manager.registerUser("Rahul");

        verify(service, times(2))
                .sendNotification(anyString());

    }

}