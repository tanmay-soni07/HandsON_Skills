import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testAddUser() {

        LoggerService logger = mock(LoggerService.class);

        doNothing().when(logger).log(anyString());

        UserService service = new UserService(logger);

        service.addUser("Tanmay");

        verify(logger).log("User Added : Tanmay");

    }

}