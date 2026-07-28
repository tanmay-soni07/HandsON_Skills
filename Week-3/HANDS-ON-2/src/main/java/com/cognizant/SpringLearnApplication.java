package com.cognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Learn Application - Main Entry Point
 * 
 * This is the main class of the Spring Boot application.
 * It contains the main() method which is the entry point for the application.
 * 
 * Hands-on 2: Spring Core - Load SimpleDateFormat from Spring Configuration XML
 * This application demonstrates:
 * - Spring XML Configuration
 * - Bean Creation using constructor injection
 * - ApplicationContext loading from XML
 * - Using Spring beans to avoid code duplication
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
		
		// Call the displayDate method to demonstrate Spring XML configuration
		displayDate();
	}
	
	/**
	 * Display Date using SimpleDateFormat loaded from Spring XML Configuration
	 * 
	 * This method demonstrates:
	 * 1. Loading Spring XML configuration from classpath
	 * 2. Creating ApplicationContext from XML file
	 * 3. Retrieving a bean from the ApplicationContext
	 * 4. Using the bean to parse and format dates
	 * 5. Avoiding code duplication by centralizing bean configuration
	 */
	public static void displayDate() {
		System.out.println("\n\n========== Hands-on 2: Spring Core - XML Configuration ==========");
		System.out.println();
		
		try {
			// Step 1: Create ApplicationContext by loading XML configuration from classpath
			System.out.println("[STEP 1] Creating ApplicationContext from 'date-format.xml'...");
			ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
			System.out.println("[SUCCESS] ApplicationContext created successfully!");
			System.out.println();
			
			// Step 2: Get the SimpleDateFormat bean from ApplicationContext
			System.out.println("[STEP 2] Retrieving 'dateFormat' bean from ApplicationContext...");
			SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
			System.out.println("[SUCCESS] Bean retrieved successfully!");
			System.out.println("[INFO] Bean class: " + format.getClass().getName());
			System.out.println("[INFO] Date format pattern: " + format.toPattern());
			System.out.println();
			
			// Step 3: Parse a date string using the format
			System.out.println("[STEP 3] Parsing date string '31/12/2018' using the format...");
			String dateString = "31/12/2018";
			Date parsedDate = format.parse(dateString);
			System.out.println("[SUCCESS] Date parsed successfully!");
			System.out.println("[INPUT] Date string: " + dateString);
			System.out.println("[OUTPUT] Parsed Date object: " + parsedDate);
			System.out.println("[OUTPUT] Formatted output: " + format.format(parsedDate));
			System.out.println();
			
			// Step 4: Demonstrate additional date operations
			System.out.println("[STEP 4] Additional Date Operations...");
			Date currentDate = new Date();
			System.out.println("[INFO] Current date formatted: " + format.format(currentDate));
			System.out.println();
			
			// Step 5: Close the ApplicationContext
			System.out.println("[STEP 5] Closing ApplicationContext...");
			if (context instanceof org.springframework.context.support.AbstractApplicationContext) {
				((org.springframework.context.support.AbstractApplicationContext) context).close();
				System.out.println("[SUCCESS] ApplicationContext closed successfully!");
			}
			
		} catch (ParseException e) {
			System.err.println("[ERROR] Failed to parse date: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("[ERROR] An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("\n========== Hands-on 2 Completed ==========");
	}

}
