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
package io.ballerinalang.quoter.utils;

import io.ballerinalang.quoter.QuoterException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Scanner;

/**
 * Reused file IO utils.
 */
public class FileReaderUtils {
    private static final String SPECIAL_DELIMITER = "\\A";

    /**
     * Reads a file path content from the resources directory.
     *
     * @param path path of the file. (root is the resources directory)
     * @return Content of the file.
     */
    public static String readFileAsResource(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        Objects.requireNonNull(inputStream, "File open failed");
        Scanner scanner = new Scanner(inputStream, Charset.defaultCharset()).useDelimiter(SPECIAL_DELIMITER);
        return scanner.hasNext() ? scanner.next() : "";
    }


    /**
     * Reads a file path content from project root.
     *
     * @param path path of the file. (root is the project root)
     * @return Content of the file.
     */
    public static String readFile(String path) {
        try (InputStream inputStream = new FileInputStream(path)) {
            Scanner scanner = new Scanner(inputStream, Charset.defaultCharset()).useDelimiter(SPECIAL_DELIMITER);
            return scanner.hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            throw new QuoterException("Failed to read " + path + ". Error: " + e.getMessage(), e);
        }
    }
}
