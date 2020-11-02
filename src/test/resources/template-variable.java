package templatepkg;

import io.ballerina.compiler.syntax.tree.*;
import io.ballerinalang.quoter.test.TemplateCode;

public class TemplateCodeImpl implements TemplateCode {
    @Override
    public Node getNode() {
        %s
        return modulePartNode;
    }
}
