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

import com.google.gson.Gson;
import io.ballerinalang.quoter.BallerinaQuoter;
import io.ballerinalang.quoter.QuoterException;
import io.ballerinalang.quoter.utils.FileReaderUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base configuration file format.
 */
public abstract class QuoterConfig {
    public static final String INTERNAL_NODE_CHILDREN_JSON = "internal.node.children";
    public static final String EXTERNAL_FORMATTER_TEMPLATE = "external.formatter.template";
    public static final String EXTERNAL_FORMATTER_USE_TEMPLATE = "external.formatter.use.template";
    public static final String EXTERNAL_FORMATTER_TAB_START = "external.formatter.tab.start";
    public static final String EXTERNAL_INPUT_FILE = "external.input.file";
    public static final String EXTERNAL_OUTPUT_FILE = "external.output.file";
    public static final String EXTERNAL_OUTPUT_SYS_OUT = "external.output.sys.out";
    public static final String EXTERNAL_FORMATTER_NAME = "external.formatter.name";

    /**
     * Get the value assigned to the key.
     * Throw an error if key is not found.
     *
     * @param key Property key
     * @return Value assigned for the key.
     */
    public abstract String getOrThrow(String key);

    /**
     * Get the boolean value assigned to the key.
     * True if value is "true".
     *
     * @param key Property key
     * @return Boolean Value assigned for the key.
     */
    public boolean getBooleanOrThrow(String key) {
        return getOrThrow(key).equalsIgnoreCase("true");
    }

    /**
     * Read the template file specified in the configuration.
     *
     * @return The content of the template file.
     */
    public String readTemplateFile() {
        return FileReaderUtils.readFile(getOrThrow(EXTERNAL_FORMATTER_TEMPLATE));
    }

    /**
     * Read input from the file specified in the configurations.
     *
     * @return The content of the input file.
     */
    public String readInputFile() {
        String inputFileName = getOrThrow(EXTERNAL_INPUT_FILE);
        return FileReaderUtils.readFile(inputFileName);
    }

    /**
     * Output the content in the way specified in the configurations.
     * Throws an exception if write failed.
     *
     * @param content The content to output.
     */
    public void writeToOutputFile(String content) {
        String outputFileName = getOrThrow(EXTERNAL_OUTPUT_FILE);
        try (OutputStream outputStream = new FileOutputStream(outputFileName)) {
            outputStream.write(content.getBytes(Charset.defaultCharset()));
        } catch (IOException e) {
            throw new QuoterException("Failed to write " + outputFileName + ". Error: " + e.getMessage(), e);
        }

        if (getBooleanOrThrow(EXTERNAL_OUTPUT_SYS_OUT)) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, content);
        }
    }

    /**
     * Get the node children config json specified in the configurations.
     * Throws an error if not found or invalid format.
     *
     * @return Parsed content of the children json file.
     */
    public Map<String, List<String>> readChildNamesJson() {
        String jsonFile = getOrThrow(INTERNAL_NODE_CHILDREN_JSON);
        ClassLoader classLoader = BallerinaQuoter.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(jsonFile);
        Gson gson = new Gson();
        Objects.requireNonNull(inputStream, "File open failed");
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return gson.fromJson(reader, CacheMap.class);
    }
}
