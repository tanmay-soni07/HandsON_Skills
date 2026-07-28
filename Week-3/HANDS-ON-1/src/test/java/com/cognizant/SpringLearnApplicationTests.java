package com.cognizant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Spring Boot Test Class
 * 
 * This test class verifies that the Spring Boot application context loads successfully.
 * It uses JUnit 5 and Spring Boot Test framework.
 */
@SpringBootTest
class SpringLearnApplicationTests {

	/**
	 * Test to verify that the application context loads successfully
	 * This is a basic smoke test to ensure the application can start without errors
	 */
	@Test
	void contextLoads() {
		System.out.println("[TEST] Spring Application Context loaded successfully!");
	}

}
