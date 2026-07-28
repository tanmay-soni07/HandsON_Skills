package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Create mock objects
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        // Create service with mocked dependencies
        MyService service = new MyService(mockApi, mockLogger);

        // Call the method
        service.fetchData();

        // Verify the interaction - check if getData() was called
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyInteractionWithSpecificArguments() {
        // Create mock objects
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        // Create service
        MyService service = new MyService(mockApi, mockLogger);

        // Call the method
        service.deleteData("123");

        // Verify that log() was called with specific argument
        verify(mockLogger).log("Deleting data with id: 123");
    }

    @Test
    public void testVerifyInteractionCalledMultipleTimes() {
        // Create mock objects
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        when(mockApi.getData()).thenReturn("Test Data");

        // Create service
        MyService service = new MyService(mockApi, mockLogger);

        // Call fetchData twice
        service.fetchData();
        service.fetchData();

        // Verify getData() was called twice
        verify(mockApi, times(2)).getData();
    }

    @Test
    public void testVerifyInteractionNeverCalled() {
        // Create mock objects
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        // Create service
        MyService service = new MyService(mockApi, mockLogger);

        // Do NOT call fetchData()

        // Verify that getData() was never called
        verify(mockApi, never()).getData();
    }

    @Test
    public void testVerifyMultipleInteractions() {
        // Create mock objects
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        when(mockApi.getStatusCode()).thenReturn(200);

        // Create service
        MyService service = new MyService(mockApi, mockLogger);

        // Call method that interacts with multiple dependencies
        service.processWithErrorHandling();

        // Verify multiple interactions in sequence
        verify(mockLogger).log("Starting process");
        verify(mockApi).getStatusCode();
        verify(mockLogger).log("Success");
    }

    @Test
    public void testVerifyInteractionNotCalledWithWrongArguments() {
        // Create mock objects
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        Logger mockLogger = Mockito.mock(Logger.class);

        // Create service
        MyService service = new MyService(mockApi, mockLogger);

        // Call deleteData with id "456"
        service.deleteData("456");

        // Verify that log() was NOT called with "id: 123"
        verify(mockLogger, never()).log("Deleting data with id: 123");
    }
}
