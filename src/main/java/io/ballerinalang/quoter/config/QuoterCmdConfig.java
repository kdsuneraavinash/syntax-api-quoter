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
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration file for CLI application.
 */
public class QuoterCmdConfig extends QuoterPropertiesConfig {
    /**
     * CLI option enum with the name and description.
     */
    protected enum CliOption {
        INPUT("input", "input file path"),
        OUTPUT("output", "output file path"),
        STDOUT("stdout", "output to stdout (true/false)"),
        FORMATTER("formatter", "formatter name (none,default,template,variable)"),
        USE_TEMPLATE("use-template", "whether to use template (true/false)"),
        TEMPLATE("template", "template to use (applicable only if use template is true)"),
        POSITION("position", "tab position to start (applicable only if use template is true)");

        final String name;
        final String description;

        CliOption(String name, String description) {
            this.name = name;
            this.description = description;
        }

        /**
         * The option parameter.
         * This is the first letter of the name.
         */
        String option() {
            return name.substring(0, 1);
        }
    }


    private final String formatterUseTemplate;
    private final String formatterTemplate;
    private final String formatterTabStart;
    private final String inputFile;
    private final String outputFile;
    private final String outputSysOut;
    private final String formatterName;

    public QuoterCmdConfig(CommandLine cmd) {
        this.formatterUseTemplate = cmd.getOptionValue(CliOption.USE_TEMPLATE.option());
        this.formatterTemplate = cmd.getOptionValue(CliOption.TEMPLATE.option());
        this.formatterTabStart = cmd.getOptionValue(CliOption.POSITION.option());
        this.inputFile = cmd.getOptionValue(CliOption.INPUT.option());
        this.outputFile = cmd.getOptionValue(CliOption.OUTPUT.option());
        this.outputSysOut = cmd.getOptionValue(CliOption.STDOUT.option());
        this.formatterName = cmd.getOptionValue(CliOption.FORMATTER.option());
    }

    /**
     * Generate the CLI options.
     *
     * @return Generated CLI options.
     */
    public static Options getCommandLineOptions() {
        Options options = new Options();
        for (CliOption op : CliOption.values()) {
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
            case EXTERNAL_INPUT_FILE:
                return overrideGet(key, inputFile);
            case EXTERNAL_OUTPUT_FILE:
                return overrideGet(key, outputFile);
            case EXTERNAL_OUTPUT_SYS_OUT:
                return overrideGet(key, outputSysOut);
            case EXTERNAL_FORMATTER_NAME:
                return overrideGet(key, formatterName);
            default:
                return super.getOrThrow(key);
        }
    }

    @Override
    public void writeToOutputFile(String content) {
        String outputFileName = getOrThrow(EXTERNAL_OUTPUT_FILE);
        try (OutputStream outputStream = new FileOutputStream(outputFileName)) {
            outputStream.write(content.getBytes(Charset.defaultCharset()));
        } catch (IOException e) {
            throw new QuoterException("Failed to write " + outputFileName + ". Error: " + e.getMessage(), e);
        }

        if (getBooleanOrThrow(EXTERNAL_OUTPUT_SYS_OUT)) {
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
}
