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

package io.quoter.application.cli;

import io.ballerina.quoter.QuoterException;
import io.ballerina.quoter.config.QuoterPropertiesConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Scanner;

/**
 * Configuration file for CLI application.
 */
public class QuoterCmdConfig extends QuoterPropertiesConfig {
    public static final String EXTERNAL_CLI_INPUT_FILE = "external.cli.input.file";
    public static final String EXTERNAL_CLI_OUTPUT_FILE = "external.cli.output.file";
    public static final String EXTERNAL_CLI_OUTPUT_SYS_OUT = "external.cli.output.sys.out";
    private static final String SPECIAL_DELIMITER = "\\A";

    private final boolean formatterUseTemplate;
    private final String formatterTemplate;
    private final int formatterTabStart;
    private final String inputFile;
    private final String outputFile;
    private final boolean outputSysOut;
    private final CodeFormatter formatter;

    private QuoterCmdConfig(Builder builder) {
        this.inputFile = builder.inputFile;
        this.outputFile = builder.outputFile;
        this.outputSysOut = builder.outputSysOut;
        this.formatter = builder.formatter;
        this.formatterUseTemplate = builder.formatterUseTemplate;
        this.formatterTemplate = builder.formatterTemplate;
        this.formatterTabStart = builder.formatterTabStart;
    }

    /**
     * Reads a file path content from project root.
     *
     * @param path path of the file. (root is the project root)
     * @return Content of the file.
     */
    private static String readFile(String path) {
        try (InputStream inputStream = new FileInputStream(path)) {
            Scanner scanner = new Scanner(inputStream, Charset.defaultCharset()).useDelimiter(SPECIAL_DELIMITER);
            return scanner.hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            throw new QuoterException("Failed to read " + path + ". Error: " + e.getMessage(), e);
        }
    }

    @Override
    public String getOrThrow(String key) {
        switch (key) {
            case EXTERNAL_FORMATTER_USE_TEMPLATE:
                return String.valueOf(formatterUseTemplate);
            case EXTERNAL_FORMATTER_TEMPLATE:
                return formatterTemplate;
            case EXTERNAL_FORMATTER_TAB_START:
                return String.valueOf(formatterTabStart);
            case EXTERNAL_CLI_INPUT_FILE:
                return inputFile;
            case EXTERNAL_CLI_OUTPUT_FILE:
                return outputFile;
            case EXTERNAL_CLI_OUTPUT_SYS_OUT:
                return String.valueOf(outputSysOut);
            case EXTERNAL_FORMATTER_NAME:
                return formatter.name;
            default:
                return super.getOrThrow(key);
        }
    }

    @Override
    public String readTemplateFile() {
        return readFile(getOrThrow(EXTERNAL_FORMATTER_TEMPLATE));
    }

    /**
     * Reads input file.
     *
     * @return Input file content.
     */
    public String readInputFile() {
        return readFile(getOrThrow(EXTERNAL_CLI_INPUT_FILE));
    }

    /**
     * Output the content in the way specified in the configurations.
     * Throws an exception if write failed.
     *
     * @param content The content to output.
     */
    public void writeToOutputFile(String content) {
        String outputFileName = getOrThrow(EXTERNAL_CLI_OUTPUT_FILE);
        try (OutputStream outputStream = new FileOutputStream(outputFileName)) {
            outputStream.write(content.getBytes(Charset.defaultCharset()));
        } catch (IOException e) {
            throw new QuoterException("Failed to write " + outputFileName + ". Error: " + e.getMessage(), e);
        }

        if (getBooleanOrThrow(EXTERNAL_CLI_OUTPUT_SYS_OUT)) {
            PrintStream outStream = System.out;
            outStream.println(content);
        }
    }

    /**
     * Code formatter to use in the formatter.
     */
    public enum CodeFormatter {
        NONE("none"),
        DEFAULT("default"),
        TEMPLATE("template"),
        VARIABLE("variable");

        private final String name;

        CodeFormatter(String name) {
            this.name = name;
        }
    }

    /**
     * Builder for cmd config class.
     */
    public static class Builder {
        private String inputFile;
        private String outputFile;
        private boolean outputSysOut;
        private CodeFormatter formatter;
        private boolean formatterUseTemplate;
        private String formatterTemplate;
        private int formatterTabStart;

        public Builder inputFile(String inputFile) {
            this.inputFile = inputFile;
            return Builder.this;
        }

        public Builder outputFile(String outputFile) {
            this.outputFile = outputFile;
            return Builder.this;
        }

        public Builder outputSysOut(boolean outputSysOut) {
            this.outputSysOut = outputSysOut;
            return Builder.this;
        }

        public Builder formatter(CodeFormatter formatter) {
            this.formatter = formatter;
            return Builder.this;
        }

        public Builder formatterUseTemplate(boolean formatterUseTemplate) {
            this.formatterUseTemplate = formatterUseTemplate;
            return Builder.this;
        }

        public Builder formatterTemplate(String formatterTemplate) {
            this.formatterTemplate = formatterTemplate;
            return Builder.this;
        }

        public Builder formatterTabStart(int formatterTabStart) {
            this.formatterTabStart = formatterTabStart;
            return Builder.this;
        }

        public QuoterCmdConfig build() {
            Objects.requireNonNull(this.inputFile, "input file is required.");
            return new QuoterCmdConfig(this);
        }
    }
}
