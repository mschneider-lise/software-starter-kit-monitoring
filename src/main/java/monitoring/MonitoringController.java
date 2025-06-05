package monitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {
    private final Logger LOG = LoggerFactory.getLogger(MonitoringController.class);
    private final Counter customCounter;

    public MonitoringController(MeterRegistry meterRegistry) {
        customCounter = Counter.builder("custom_counter").tag("version", "v1").description("Custom Counter").register(meterRegistry);
    }

    @GetMapping("info")
    public void info() {
        LOG.info("This is an info log message");
    }

    @GetMapping("error")
    public void error() throws Exception {
        throw new Exception("This is an exception");
    }

    @GetMapping("custom-counter")
    public void customCounter() {
        customCounter.increment();
    }
}
