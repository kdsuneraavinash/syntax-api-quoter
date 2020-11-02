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
package io.ballerinalang.quoter.segment.factories;

import io.ballerina.compiler.syntax.tree.Minutiae;
import io.ballerina.compiler.syntax.tree.MinutiaeList;
import io.ballerina.compiler.syntax.tree.SyntaxKind;
import io.ballerinalang.quoter.QuoterException;
import io.ballerinalang.quoter.segment.NodeFactorySegment;
import io.ballerinalang.quoter.segment.Segment;

/**
 * Handles {@link Minutiae} to {@link Segment} conversion.
 */
public class MinutiaeSegmentFactory {
    private static final String CREATE_EMPTY_MINUTIAE_LIST_METHOD_NAME = "createEmptyMinutiaeList";
    private static final String CREATE_MINUTIAE_LIST_METHOD_NAME = "createMinutiaeList";
    private static final String CREATE_COMMENT_METHOD_NAME = "createCommentMinutiae";
    private static final String CREATE_WHITESPACE_METHOD_NAME = "createWhitespaceMinutiae";
    private static final String CREATE_EOL_METHOD_NAME = "createEndOfLineMinutiae";

    /**
     * Converts a {@link MinutiaeList} to a {@link Segment}.
     *
     * @param minutiaeList Minutiae list to create from.
     * @return Created minutiae segments.
     */
    public static Segment createMinutiaeListSegment(MinutiaeList minutiaeList) {
        if (minutiaeList.isEmpty()) {
            return SegmentFactory.createNodeFactorySegment(CREATE_EMPTY_MINUTIAE_LIST_METHOD_NAME);
        }

        // If the list is not empty, create the factory segment and add every minutiae segment
        NodeFactorySegment minutiaeListMethod = SegmentFactory
                .createNodeFactorySegment(CREATE_MINUTIAE_LIST_METHOD_NAME);
        minutiaeList.forEach(minutiae -> minutiaeListMethod.addParameter(createMinutiaeSegment(minutiae)));
        return minutiaeListMethod;
    }

    /**
     * Converts a {@link Minutiae} to a {@link Segment}.
     * Used by `createMinutiaeListSegment` to convert all minutiae elements to segments.
     * Throws as error if minutiae is unknown or is a INVALID_NODE_MINUTIAE.
     *
     * @param minutiae Individual minutiae.
     * @return Created minutiae Segment.
     */
    private static Segment createMinutiaeSegment(Minutiae minutiae) {
        // Decide on method to use
        String methodName;
        if (minutiae.kind() == SyntaxKind.COMMENT_MINUTIAE) {
            methodName = CREATE_COMMENT_METHOD_NAME;
        } else if (minutiae.kind() == SyntaxKind.WHITESPACE_MINUTIAE) {
            methodName = CREATE_WHITESPACE_METHOD_NAME;
        } else if (minutiae.kind() == SyntaxKind.END_OF_LINE_MINUTIAE) {
            methodName = CREATE_EOL_METHOD_NAME;
        } else if (minutiae.kind() == SyntaxKind.INVALID_NODE_MINUTIAE) {
            throw new QuoterException("Invalid node minutiae found with text: " + minutiae.text());
        } else {
            throw new QuoterException("Unexpected Minutiae found");
        }

        // All minutiae factory methods accept only the text
        NodeFactorySegment nodeFactorySegment = SegmentFactory.createNodeFactorySegment(methodName);
        nodeFactorySegment.addParameter(SegmentFactory.createStringSegment(minutiae.text()));
        return nodeFactorySegment;
    }
}
