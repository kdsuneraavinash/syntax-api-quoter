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

package io.ballerina.quoter.formatter;

import io.ballerina.quoter.QuoterException;
import io.ballerina.quoter.config.QuoterConfig;
import io.ballerina.quoter.segment.Segment;

/**
 * Base formatter.
 */
public abstract class SegmentFormatter {
    private static final String NONE_FORMATTER = "none";
    private static final String VARIABLE_FORMATTER = "variable";
    private static final String DEFAULT_FORMATTER = "default";

    /**
     * Creates a formatter based on the configuration option.
     * Creates a template formatter with the internal formatter if that option is set.
     *
     * @param config Configuration object.
     * @return Created formatter.
     */
    public static SegmentFormatter getFormatter(QuoterConfig config) {
        if (config.getBooleanOrThrow(QuoterConfig.EXTERNAL_FORMATTER_USE_TEMPLATE)) {
            return TemplateFormatter.fromConfig(config);
        } else {
            return getInternalFormatter(config);
        }
    }

    /**
     * Creates a internal formatter. (A formatter without templates)
     * Throws an error if the formatter is unknown.
     *
     * @param config Configuration object.
     * @return Created formatter.
     */
    protected static SegmentFormatter getInternalFormatter(QuoterConfig config) {
        String formatterName = config.getOrThrow(QuoterConfig.EXTERNAL_FORMATTER_NAME);
        switch (formatterName) {
            case NONE_FORMATTER:
                return new NoFormatter();
            case DEFAULT_FORMATTER:
                return new DefaultFormatter();
            case VARIABLE_FORMATTER:
                return new VariableFormatter();
            default:
                throw new QuoterException("Unknown formatter name: " + formatterName);
        }
    }

    /**
     * Formatting method.
     * Formats a segment into string representation of the required format.
     *
     * @param segment Segment root node.
     * @return String representation.
     */
    public abstract String format(Segment segment);
}
