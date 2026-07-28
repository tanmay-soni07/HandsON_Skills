package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnCountryApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(SpringLearnCountryApplication.class);
    
    public static void main(String[] args) {
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("Starting Spring Learn Country REST Service Application");
        logger.info("═══════════════════════════════════════════════════════════");
        
        SpringApplication.run(SpringLearnCountryApplication.class, args);
        
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("Spring Learn Country Application Started Successfully!");
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("Application is running on: http://localhost:8083");
        logger.info("");
        logger.info("Available Endpoints:");
        logger.info("  GET /countries/{code}  - Get country by code");
        logger.info("  GET /country/{code}    - Alternative endpoint");
        logger.info("");
        logger.info("Examples:");
        logger.info("  http://localhost:8083/countries/in");
        logger.info("  http://localhost:8083/countries/US");
        logger.info("  http://localhost:8083/countries/uk");
        logger.info("");
        logger.info("═══════════════════════════════════════════════════════════");
    }
}
