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

import io.ballerina.quoter.QuoterException;
import io.ballerina.quoter.config.QuoterPropertiesConfig;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Scanner;

/**
 * Configuration file for Spring web application.
 */
public class QuoterSpringConfig extends QuoterPropertiesConfig {
    public static final String INTERNAL_WEB_DEFAULT_TEMPLATE = "internal.web.default.template";
    public static final String INTERNAL_WEB_VARIABLE_TEMPLATE = "internal.web.variable.template";
    private static final String SPECIAL_DELIMITER = "\\A";

    private final String formatter;
    private final boolean useTemplate;
    private final String parser;
    private final boolean ignoreMinutiae;

    private QuoterSpringConfig(Builder builder) {
        this.formatter = builder.formatter;
        this.useTemplate = builder.useTemplate;
        this.parser = builder.parser;
        this.ignoreMinutiae = builder.ignoreMinutiae;
    }

    @Override
    public String getOrThrow(String key) {
        switch (key) {
            case EXTERNAL_FORMATTER_NAME:
                return formatter;
            case EXTERNAL_FORMATTER_USE_TEMPLATE:
                return String.valueOf(useTemplate);
            case EXTERNAL_PARSER_NAME:
                return parser;
            case EXTERNAL_IGNORE_MINUTIAE:
                return String.valueOf(ignoreMinutiae);
            default:
                return super.getOrThrow(key);
        }
    }

    @Override
    public String readTemplateFile() {
        String path = getTemplateName();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        Objects.requireNonNull(inputStream, "File open failed");
        Scanner scanner = new Scanner(inputStream, Charset.defaultCharset()).useDelimiter(SPECIAL_DELIMITER);
        return scanner.hasNext() ? scanner.next() : "";
    }

    /**
     * Get the template for each formatter.
     * Throws an error if unknown formatter type.
     *
     * @return Template name for the formatter.
     */
    private String getTemplateName() {
        switch (formatter) {
            case "variable":
                return getOrThrow(INTERNAL_WEB_VARIABLE_TEMPLATE);
            case "default":
                return getOrThrow(INTERNAL_WEB_DEFAULT_TEMPLATE);
            default:
                throw new QuoterException("Formatter template unknown.");
        }
    }

    public static class Builder {
        private String formatter;
        private boolean useTemplate;
        private String parser;
        private boolean ignoreMinutiae;

        public Builder formatter(String formatter) {
            this.formatter = formatter;
            return Builder.this;
        }

        public Builder useTemplate(boolean useTemplate) {
            this.useTemplate = useTemplate;
            return Builder.this;
        }

        public Builder parser(String parser) {
            this.parser = parser;
            return Builder.this;
        }

        public Builder ignoreMinutiae(boolean ignoreMinutiae) {
            this.ignoreMinutiae = ignoreMinutiae;
            return Builder.this;
        }

        public QuoterSpringConfig build() {
            Objects.requireNonNull(this.formatter, "Formatter not set");
            Objects.requireNonNull(this.parser, "Parser not set");
            return new QuoterSpringConfig(this);
        }
    }
}
