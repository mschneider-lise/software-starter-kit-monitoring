package monitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    private final Logger LOG = LoggerFactory.getLogger(TestController.class);

    private final Counter testCounter;

    public TestController(MeterRegistry meterRegistry) {
        testCounter = Counter.builder("test_counter").tag("version", "v1").description("Test Counter").register(meterRegistry);
    }

    @GetMapping("test")
    public String test() {
        LOG.atInfo().addKeyValue("trace_id", UUID.randomUUID().toString()).log("test");
        testCounter.increment();
        return "test";
    }
}
