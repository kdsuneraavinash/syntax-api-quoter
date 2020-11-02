import ballerina/test;

string log = "";

// This is the mock function which will replace the real function
@test:Mock {
    moduleName: "ballerina/log",
    functionName: "printInfo"
}
public isolated function mockPrintInfo(anydata|(function () returns (anydata)) msg) {
    if (msg is string) {
        log = msg;
    }
}

@test:Config {}
function testFunc() {
    // Invoking the main function
    main();
    test:assertEquals(log, "Hello, World!!!");
}
