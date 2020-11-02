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
package io.ballerinalang.quoter.test;

import io.ballerinalang.quoter.config.QuoterConfig;
import io.ballerinalang.quoter.utils.FileReaderUtils;

/**
 * Configuration file used for testing purposes.
 * Overrides several parameters with test parameters.
 */
public class TestQuoterConfig extends QuoterConfig {
    private final String externalFormatterTemplate;
    private final String externalFormatterTabStart;
    private final String externalFormatterName;

    public TestQuoterConfig(String externalFormatterTemplate,
                            int externalFormatterTabStart,
                            String externalFormatterName) {
        this.externalFormatterTemplate = externalFormatterTemplate;
        this.externalFormatterTabStart = String.valueOf(externalFormatterTabStart);
        this.externalFormatterName = externalFormatterName;
    }

    @Override
    public String getOrThrow(String key) {
        switch (key) {
            case EXTERNAL_FORMATTER_TEMPLATE:
                return externalFormatterTemplate;
            case EXTERNAL_FORMATTER_TAB_START:
                return externalFormatterTabStart;
            case INTERNAL_NODE_CHILDREN_JSON:
                return "child-names.json";
            case EXTERNAL_FORMATTER_NAME:
                return externalFormatterName;
            case EXTERNAL_FORMATTER_USE_TEMPLATE:
                return "true";
            default:
                throw new RuntimeException("Unknown key: " + key);
        }
    }

    @Override
    public String readTemplateFile() {
        return FileReaderUtils.readFileAsResource(getOrThrow(EXTERNAL_FORMATTER_TEMPLATE));
    }
}
