package io.quoter.application.server;

import io.ballerina.quoter.BallerinaQuoter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Spring web application entry point.
 */
@RestController
@SpringBootApplication
@RequestMapping("/generate")
public class QuoterSpringBoot {
    private static final Logger logger = LoggerFactory.getLogger(QuoterSpringBoot.class);

    public static void main(String[] args) {
        SpringApplication.run(QuoterSpringBoot.class, args);
    }

    /**
     * Endpoint for the REST API call to generate code.
     *
     * @param formatterName REST parameter for the formatter (default/variable)
     * @param useTemplate   REST parameter to denote whether to use formatter
     * @param source        Source code string
     * @return Generated source code. Error message if failed.
     */
    @PostMapping
    @ResponseBody
    public String codeResponse(
            @RequestParam(value = "format", defaultValue = "default") String formatterName,
            @RequestParam(value = "template", defaultValue = "true") boolean useTemplate,
            @RequestBody(required = false) String source) {
        try {
            source = Objects.requireNonNullElse(source, "");
            QuoterSpringConfig config = new QuoterSpringConfig(formatterName, useTemplate);
            return BallerinaQuoter.run(source, config);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}