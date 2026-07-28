package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Learn Application - Main Entry Point
 * 
 * This is the main class of the Spring Boot application.
 * It contains the main() method which is the entry point for the application.
 */
@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		System.out.println("========== Spring Learn Application Starting ==========");
		System.out.println("[INFO] Initializing Spring Boot Application Context...");
		System.out.println("[INFO] Loading Configuration from application.properties...");
		
		SpringApplication.run(SpringLearnApplication.class, args);
		
		System.out.println("========== Spring Learn Application Started Successfully ==========");
		System.out.println("[INFO] Application is ready to serve requests on port 8080");
		System.out.println("[INFO] Access the application at: http://localhost:8080");
	}

}
