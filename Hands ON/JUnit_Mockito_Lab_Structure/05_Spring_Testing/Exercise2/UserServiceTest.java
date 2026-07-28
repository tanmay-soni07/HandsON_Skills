import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetUserName() {

        assertEquals("Tanmay", userService.getUserName());

    }

    @Test
    void testAddition() {

        assertEquals(30, userService.add(10, 20));

    }

}