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

import io.ballerina.quoter.BallerinaQuoter;
import picocli.CommandLine;

import java.util.concurrent.Callable;


/**
 * CLI Entry point of the programme.
 */
@CommandLine.Command(name = "quoter",
        mixinStandardHelpOptions = true, version = "quoter shell version 0.0.1",
        description = "Syntax API Quoter for Ballerina Language.")
public class QuoterCommandLine implements Callable<Integer> {
    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal", "unused"})
    @CommandLine.Option(names = {"-i", "--input"}, description = "input file path", required = true)
    private String input;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-o", "--output"}, description = "output file path")
    private String output = "output.txt";

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-s", "--stdout"}, description = "output to stdout")
    private boolean stdout = true;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-f", "--formatter"}, description = "formatter name")
    private QuoterCmdConfig.CodeFormatter formatter = QuoterCmdConfig.CodeFormatter.DEFAULT;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-u", "--use-template"}, description = "whether to use templates")
    private boolean useTemplate = false;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-t", "--template"},
            description = "template to use (applicable only if use template is true)")
    private String template = "template.txt";

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"--position"},
            description = "tab position to start (applicable only if use template is true)")
    private int position = 2;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-p", "--parser"}, description = "parser name")
    private QuoterCmdConfig.CodeParser parser = QuoterCmdConfig.CodeParser.MODULE;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-x", "--timeout"}, description = "parser timeout (in milliseconds)")
    private long parserTimeout = 2500;

    @SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
    @CommandLine.Option(names = {"-m", "--ignore-minutiae"}, description = "whether to ignore minutiae (whitespaces)")
    private boolean ignoreMinutiae = false;

    /**
     * Launch the Quoter.
     *
     * @param args Optional arguments.
     */
    public static void main(String... args) {
        int exitCode = new CommandLine(new QuoterCommandLine())
                .setCaseInsensitiveEnumValuesAllowed(true).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        QuoterCmdConfig configuration = new QuoterCmdConfig.Builder()
                .inputFile(input)
                .outputFile(output)
                .outputSysOut(stdout)
                .formatter(formatter)
                .formatterUseTemplate(useTemplate)
                .formatterTemplate(template)
                .formatterTabStart(position)
                .parser(parser)
                .parserTimeout(parserTimeout)
                .ignoreMinutiae(ignoreMinutiae)
                .build();

        String source = configuration.readInputFile();
        String output = BallerinaQuoter.run(source, configuration);
        configuration.writeToOutputFile(output);
        return 0;
    }
}

