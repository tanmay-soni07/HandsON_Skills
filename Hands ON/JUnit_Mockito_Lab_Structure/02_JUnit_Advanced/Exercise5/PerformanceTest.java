import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {

    Performance performance = new Performance();

    @Test
    void testPerformance() {

        assertTimeout(Duration.ofSeconds(2), () -> {

            performance.executeTask();

        });

    }

}