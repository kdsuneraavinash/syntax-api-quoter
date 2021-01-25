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


/**
 * CLI option enum with the name and description.
 */
enum CmdOption {
    INPUT("input", "input file path"),
    OUTPUT("output", "output file path"),
    STDOUT("stdout", "output to stdout (true/false)"),
    FORMATTER("formatter", "formatter name (none,default,template,variable)"),
    USE_TEMPLATE("use-template", "whether to use template (true/false)"),
    TEMPLATE("template", "template to use (applicable only if use template is true)"),
    POSITION("position", "tab position to start (applicable only if use template is true)");

    final String name;
    final String description;

    CmdOption(String name, String description) {
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
