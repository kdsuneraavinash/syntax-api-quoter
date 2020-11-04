import ballerina/test;

string[] outputs = [];

// This is the mock function which will replace the real function
@test:Mock {
    moduleName: "ballerina/io",
    functionName: "println"
}
public isolated function mockPrint(any|error... val) {
    outputs.push(val.reduce(function (any|error a, any|error b) returns string => a.toString() + b.toString(), "").toString());
}

@test:Config {}
function testFunc() {
    error? output = main();
    test:assertEquals(outputs[0], "Attempting execution...");
    test:assertEquals(outputs[1], "Attempting execution...");
    test:assertEquals(outputs[2], "Work done.");
}
