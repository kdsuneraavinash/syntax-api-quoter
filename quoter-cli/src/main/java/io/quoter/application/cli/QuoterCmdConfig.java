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
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration file for CLI application.
 */
public class QuoterCmdConfig extends QuoterPropertiesConfig {
    public static final String EXTERNAL_CLI_INPUT_FILE = "external.cli.input.file";
    public static final String EXTERNAL_CLI_OUTPUT_FILE = "external.cli.output.file";
    public static final String EXTERNAL_CLI_OUTPUT_SYS_OUT = "external.cli.output.sys.out";
    private static final String SPECIAL_DELIMITER = "\\A";

    private final String formatterUseTemplate;
    private final String formatterTemplate;
    private final String formatterTabStart;
    private final String inputFile;
    private final String outputFile;
    private final String outputSysOut;
    private final String formatterName;

    public QuoterCmdConfig(CommandLine cmd) {
        this.formatterUseTemplate = cmd.getOptionValue(CmdOption.USE_TEMPLATE.option());
        this.formatterTemplate = cmd.getOptionValue(CmdOption.TEMPLATE.option());
        this.formatterTabStart = cmd.getOptionValue(CmdOption.POSITION.option());
        this.inputFile = cmd.getOptionValue(CmdOption.INPUT.option());
        this.outputFile = cmd.getOptionValue(CmdOption.OUTPUT.option());
        this.outputSysOut = cmd.getOptionValue(CmdOption.STDOUT.option());
        this.formatterName = cmd.getOptionValue(CmdOption.FORMATTER.option());
    }

    /**
     * Generate the CLI options.
     *
     * @return Generated CLI options.
     */
    public static Options getCommandLineOptions() {
        Options options = new Options();
        for (CmdOption op : CmdOption.values()) {
            Option option = new Option(op.option(), op.name, true, op.description);
            option.setRequired(false);
            options.addOption(option);
        }
        return options;
    }

    @Override
    public String getOrThrow(String key) {
        switch (key) {
            case EXTERNAL_FORMATTER_USE_TEMPLATE:
                return overrideGet(key, formatterUseTemplate);
            case EXTERNAL_FORMATTER_TEMPLATE:
                return overrideGet(key, formatterTemplate);
            case EXTERNAL_FORMATTER_TAB_START:
                return overrideGet(key, formatterTabStart);
            case EXTERNAL_CLI_INPUT_FILE:
                return overrideGet(key, inputFile);
            case EXTERNAL_CLI_OUTPUT_FILE:
                return overrideGet(key, outputFile);
            case EXTERNAL_CLI_OUTPUT_SYS_OUT:
                return overrideGet(key, outputSysOut);
            case EXTERNAL_FORMATTER_NAME:
                return overrideGet(key, formatterName);
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
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "\n\n" + content);
        }
    }

    /**
     * Get the value assigned to a key from either config file
     * or a overridden value.
     * If overridden value is null, reads from the config file instead.
     *
     * @param key      Property key
     * @param override Value to override the config file value with
     * @return Value assigned to key
     */
    private String overrideGet(String key, String override) {
        if (Objects.isNull(override)) {
            return super.getOrThrow(key);
        }
        return override;
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
}
