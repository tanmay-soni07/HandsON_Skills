import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {

        String name = "Tanmay";
        int age = 21;

        logger.info("Student Name: {}, Age: {}", name, age);

        double salary = 50000;

        logger.debug("Salary is {}", salary);

        logger.warn("Account balance is low for {}", name);

        logger.error("Unable to process request for {}", name);

    }

}