import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testStubbing() {

        UserRepository repository = mock(UserRepository.class);

        when(repository.getUserName())
                .thenReturn("Tanmay")
                .thenReturn("Rahul");

        UserService service = new UserService(repository);

        assertEquals("Tanmay", service.fetchUser());

        assertEquals("Rahul", service.fetchUser());

    }

}