package io.ballerinalang.quoter;

import io.ballerinalang.quoter.config.QuoterSpringConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@SpringBootApplication
public class QuoterSpringBoot {
    private static final String FRONT_END_URL = "http://localhost:3000";
    private static final String ENDPOINT = "/generate";
    private static final Logger logger = LoggerFactory.getLogger(QuoterSpringBoot.class);

    public static void main(String[] args) {
        SpringApplication.run(QuoterSpringBoot.class, args);
    }

    @CrossOrigin(origins = FRONT_END_URL)
    @PostMapping(ENDPOINT)
    public String codeResponse(
            @RequestParam(value = "format", defaultValue = "default") String formatterName,
            @RequestParam(value = "template", defaultValue = "true") boolean useTemplate,
            @RequestBody(required = false) String source) {
        try {
            source = Objects.requireNonNullElse(source, "");
            QuoterSpringConfig config = new QuoterSpringConfig(source, formatterName, useTemplate);
            BallerinaQuoter.run(config);
            return config.getGeneratedCode();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}
