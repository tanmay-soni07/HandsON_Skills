package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
    private List<Country> countryList;
    
    public CountryService() {
        logger.info("Initializing CountryService");
        initializeCountries();
    }
    
    private void initializeCountries() {
        logger.info("Loading country data from in-memory list");
        countryList = new ArrayList<>();
        
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("UK", "United Kingdom"));
        countryList.add(new Country("AU", "Australia"));
        countryList.add(new Country("CA", "Canada"));
        countryList.add(new Country("DE", "Germany"));
        countryList.add(new Country("FR", "France"));
        countryList.add(new Country("JP", "Japan"));
        countryList.add(new Country("CN", "China"));
        countryList.add(new Country("BR", "Brazil"));
        countryList.add(new Country("MX", "Mexico"));
        countryList.add(new Country("SG", "Singapore"));
        countryList.add(new Country("NZ", "New Zealand"));
        countryList.add(new Country("SE", "Sweden"));
        countryList.add(new Country("NL", "Netherlands"));
        
        logger.info("Country list initialized with " + countryList.size() + " countries");
    }
    
    public Country getCountry(String code) {
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("START: getCountry() method execution");
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("Searching for country with code: " + code);
        
        if (code == null || code.isEmpty()) {
            logger.warn("Country code is null or empty");
            logger.info("END: getCountry() method execution");
            logger.info("═══════════════════════════════════════════════════════════");
            return null;
        }
        
        String searchCode = code.toUpperCase();
        logger.info("Converted code to uppercase: " + searchCode);
        logger.info("Total countries in database: " + countryList.size());
        
        logger.info("Searching using Lambda expression with Stream API");
        Optional<Country> foundCountry = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(searchCode))
                .findFirst();
        
        if (foundCountry.isPresent()) {
            Country country = foundCountry.get();
            logger.info("✓ Country found: " + country);
            logger.info("Country Code: " + country.getCode());
            logger.info("Country Name: " + country.getName());
            logger.info("Returning country to controller");
        } else {
            logger.warn("✗ Country not found for code: " + code);
            logger.info("Returning null");
        }
        
        logger.info("═══════════════════════════════════════════════════════════");
        logger.info("END: getCountry() method execution");
        logger.info("═══════════════════════════════════════════════════════════");
        
        return foundCountry.orElse(null);
    }
    
    public List<Country> getAllCountries() {
        logger.info("Fetching all countries");
        logger.info("Total countries available: " + countryList.size());
        return new ArrayList<>(countryList);
    }
}
