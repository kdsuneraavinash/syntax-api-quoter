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
package io.ballerinalang.quoter.config;

import io.ballerinalang.quoter.QuoterException;
import io.ballerinalang.quoter.formatter.SegmentFormatterType;
import io.ballerinalang.quoter.utils.FileReaderUtils;

import java.util.Objects;

/**
 * Configuration file for Spring web application.
 */
public class QuoterSpringConfig extends QuoterPropertiesConfig {
    public static final String INTERNAL_WEB_DEFAULT_TEMPLATE = "internal.web.default.template";
    public static final String INTERNAL_WEB_VARIABLE_TEMPLATE = "internal.web.variable.template";

    private final SegmentFormatterType formatter;
    private final boolean useTemplate;
    private final String sourceCode;
    private String generatedCode;

    public QuoterSpringConfig(String sourceCode, String formatterName, boolean useTemplate) {
        this.formatter = SegmentFormatterType.getSegmentFormatterType(formatterName);
        this.useTemplate = useTemplate;
        this.sourceCode = sourceCode;
        this.generatedCode = null;
    }

    @Override
    public String getOrThrow(String key) {
        switch (key) {
            case EXTERNAL_FORMATTER_NAME:
                return formatter.getName();
            case EXTERNAL_FORMATTER_USE_TEMPLATE:
                return String.valueOf(useTemplate);
            default:
                return super.getOrThrow(key);
        }
    }

    @Override
    public String readInputFile() {
        return sourceCode;
    }

    @Override
    public void writeToOutputFile(String content) {
        this.generatedCode = content;
    }

    @Override
    public String readTemplateFile() {
        return FileReaderUtils.readFileAsResource(getTemplateName());
    }

    /**
     * Returns generated code.
     * Throws an error if code not generated yet.
     *
     * @return Generated code.
     */
    public String getGeneratedCode() {
        Objects.requireNonNull(generatedCode, "Code not generated yet.");
        return generatedCode;
    }

    /**
     * Get the template for each formatter.
     * Throws an error if unknown formatter type.
     *
     * @return Template name for the formatter.
     */
    private String getTemplateName() {
        switch (formatter) {
            case VARIABLE_FORMATTER:
                return getOrThrow(INTERNAL_WEB_VARIABLE_TEMPLATE);
            case DEFAULT_FORMATTER:
                return getOrThrow(INTERNAL_WEB_DEFAULT_TEMPLATE);
            default:
                throw new QuoterException("Formatter template unknown.");
        }
    }
}
