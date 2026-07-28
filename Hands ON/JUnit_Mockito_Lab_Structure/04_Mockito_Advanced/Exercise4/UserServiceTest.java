import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testNoMoreInteractions() {

        AuditService audit = mock(AuditService.class);

        UserService service = new UserService(audit);

        service.createUser("Tanmay");

        verify(audit).log("Created User : Tanmay");

        verifyNoMoreInteractions(audit);

    }

}