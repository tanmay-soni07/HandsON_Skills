package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
    
    @Autowired
    private CountryService countryService;
    
    @GetMapping("/countries/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("START: getCountry() controller method execution");
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("Request received for endpoint: GET /countries/{code}");
        logger.info("Country Code from URL: " + code);
        logger.info("Timestamp: " + System.currentTimeMillis());
        
        try {
            logger.info("Calling CountryService.getCountry() with code: " + code);
            Country country = countryService.getCountry(code);
            
            if (country != null) {
                logger.info("✓ Country found successfully");
                logger.info("Country Details: " + country);
                logger.info("Returning 200 OK with country object");
                logger.info("═══════════════════════════════════════════════════════════");
                logger.info("END: getCountry() controller method execution");
                logger.info("═══════════════════════════════════════════════════════════");
                return ResponseEntity.ok(country);
            } else {
                logger.warn("✗ Country not found for code: " + code);
                logger.info("Returning 404 Not Found");
                logger.info("═══════════════════════════════════════════════════════════");
                logger.info("END: getCountry() controller method execution");
                logger.info("═══════════════════════════════════════════════════════════");
                return ResponseEntity.notFound().build();
            }
            
        } catch (Exception e) {
            logger.error("Error occurred while fetching country: " + e.getMessage(), e);
            logger.info("Returning 500 Internal Server Error");
            logger.info("═══════════════════════════════════════════════════════════");
            logger.info("END: getCountry() controller method execution");
            logger.info("═══════════════════════════════════════════════════════════");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/country/{code}")
    public ResponseEntity<Country> getCountryShort(@PathVariable String code) {
        logger.info("Request received for alternate endpoint: GET /country/{code}");
        return getCountry(code);
    }
}
