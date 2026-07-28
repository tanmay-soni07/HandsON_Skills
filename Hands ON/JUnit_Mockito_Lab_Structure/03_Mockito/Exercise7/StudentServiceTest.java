import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class StudentServiceTest {

    @Test
    void testArgumentMatchers() {

        StudentRepository repository = mock(StudentRepository.class);

        when(repository.findStudent(anyInt()))
                .thenReturn("Tanmay");

        StudentService service = new StudentService(repository);

        assertEquals("Tanmay", service.getStudent(101));

        verify(repository).findStudent(anyInt());

    }

    @Test
    void testEqMatcher() {

        StudentRepository repository = mock(StudentRepository.class);

        when(repository.findStudent(eq(1)))
                .thenReturn("Rahul");

        StudentService service = new StudentService(repository);

        assertEquals("Rahul", service.getStudent(1));

    }

}