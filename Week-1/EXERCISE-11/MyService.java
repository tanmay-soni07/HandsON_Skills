package com.example;

public class MyService {

    private ExternalApi externalApi;
    private Logger logger;

    public MyService(ExternalApi externalApi, Logger logger) {
        this.externalApi = externalApi;
        this.logger = logger;
    }

    public String fetchData() {
        logger.log("Fetching data from API");
        String data = externalApi.getData();
        logger.log("Data fetched successfully: " + data);
        return data;
    }

    public void processWithErrorHandling() {
        try {
            logger.log("Starting process");
            int statusCode = externalApi.getStatusCode();
            if (statusCode == 200) {
                logger.log("Success");
            } else {
                logger.error("API returned status: " + statusCode);
            }
        } catch (Exception e) {
            logger.error("Error occurred: " + e.getMessage());
        }
    }

    public void deleteData(String id) {
        logger.log("Deleting data with id: " + id);
    }
}
