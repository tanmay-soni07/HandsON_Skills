import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void loginTest() {
        System.out.println("Login Test");
    }

    @Test
    @Order(2)
    void searchProductTest() {
        System.out.println("Search Product Test");
    }

    @Test
    @Order(3)
    void addToCartTest() {
        System.out.println("Add To Cart Test");
    }

    @Test
    @Order(4)
    void paymentTest() {
        System.out.println("Payment Test");
    }

    @Test
    @Order(5)
    void logoutTest() {
        System.out.println("Logout Test");
    }

}