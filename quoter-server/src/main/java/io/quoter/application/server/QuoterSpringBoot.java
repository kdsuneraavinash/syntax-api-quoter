/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

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
            @RequestParam(value = "parser", defaultValue = "true") String parser,
            @RequestParam(value = "ignoreMinutiae", defaultValue = "false") boolean ignoreMinutiae,
            @RequestBody(required = false) String source) {
        try {
            source = Objects.requireNonNullElse(source, "");
            QuoterSpringConfig config = new QuoterSpringConfig.Builder()
                    .formatter(formatterName)
                    .useTemplate(useTemplate)
                    .parser(parser)
                    .ignoreMinutiae(ignoreMinutiae)
                    .build();
            return BallerinaQuoter.run(source, config);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}
