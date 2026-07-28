package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the methods to return predefined values
        when(mockApi.getData()).thenReturn("Mock Data");

        // Create service with mocked API
        MyService service = new MyService(mockApi);

        // Act and Assert
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testApiHealthy() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the getStatusCode method to return 200
        when(mockApi.getStatusCode()).thenReturn(200);

        // Create service with mocked API
        MyService service = new MyService(mockApi);

        // Act and Assert
        assertTrue(service.isApiHealthy());
    }

    @Test
    public void testApiUnhealthy() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the getStatusCode method to return 500
        when(mockApi.getStatusCode()).thenReturn(500);

        // Create service with mocked API
        MyService service = new MyService(mockApi);

        // Act and Assert
        assertFalse(service.isApiHealthy());
    }

    @Test
    public void testMultipleStubs() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub multiple methods
        when(mockApi.getData()).thenReturn("User Data");
        when(mockApi.getStatusCode()).thenReturn(200);

        // Create service with mocked API
        MyService service = new MyService(mockApi);

        // Act and Assert
        assertEquals("User Data", service.fetchData());
        assertTrue(service.isApiHealthy());
    }
}
