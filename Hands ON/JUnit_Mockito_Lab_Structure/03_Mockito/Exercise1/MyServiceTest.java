import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testFetchData() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Hello Mockito");

        MyService service = new MyService(mockApi);

        String result = service.fetchData();

        assertEquals("Hello Mockito", result);

    }

}