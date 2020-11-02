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

import io.ballerina.compiler.syntax.tree.DocumentationLineToken;
import io.ballerina.compiler.syntax.tree.IdentifierToken;
import io.ballerina.compiler.syntax.tree.LiteralValueToken;
import io.ballerina.compiler.syntax.tree.Token;
import io.ballerinalang.quoter.segment.NodeFactorySegment;

/**
 * Handles {@link Token}(Leaf Nodes) to {@link NodeFactorySegment} conversion.
 */
public class TokenSegmentFactory {
    private static final String CREATE_LITERAL_METHOD_NAME = "createLiteralValueToken";
    private static final String CREATE_IDENTIFIER_METHOD_NAME = "createIdentifierToken";
    private static final String CREATE_DOC_LINE_METHOD_NAME = "createDocumentationLineToken";
    private static final String CREATE_TOKEN_METHOD_NAME = "createToken";

    /**
     * Converts Token to Segment.
     * Handles minutia of the token as well.
     *
     * @param token Token node to convert.
     * @return Created segment.
     */
    public static NodeFactorySegment createTokenSegment(Token token) {
        // Decide on the method and add all parameters required, except for minutiae parameters.
        // If there are no minutiae and the token constructor supports calling without minutiae, use that call.
        NodeFactorySegment root;

        // Decide on factory call and add parameters(except minutiae)
        if (token instanceof LiteralValueToken) {
            root = SegmentFactory.createNodeFactorySegment(CREATE_LITERAL_METHOD_NAME);
            root.addParameter(SegmentFactory.createSyntaxKindSegment(token.kind()));
            root.addParameter(SegmentFactory.createStringSegment(token.text()));
        } else if (token instanceof IdentifierToken) {
            root = SegmentFactory.createNodeFactorySegment(CREATE_IDENTIFIER_METHOD_NAME);
            root.addParameter(SegmentFactory.createStringSegment(token.text()));
        } else if (token instanceof DocumentationLineToken) {
            root = SegmentFactory.createNodeFactorySegment(CREATE_DOC_LINE_METHOD_NAME);
            root.addParameter(SegmentFactory.createStringSegment(token.text()));
        } else {
            root = SegmentFactory.createNodeFactorySegment(CREATE_TOKEN_METHOD_NAME);
            root.addParameter(SegmentFactory.createSyntaxKindSegment(token.kind()));
        }

        // Add leading and trailing minutiae parameters to the call.
        root.addParameter(MinutiaeSegmentFactory.createMinutiaeListSegment(token.leadingMinutiae()));
        root.addParameter(MinutiaeSegmentFactory.createMinutiaeListSegment(token.trailingMinutiae()));
        return root;
    }
}
