import ballerina/test;
import ballerina/http;

boolean serviceStarted = false;

@test:Config {}
function testFunc() {
    // Invoking the main function.
    http:Client httpEndpoint = new("http://localhost:9092");

    json response1 = { "Outbound request content": "Length-20" };

    // Sending a GET request to the specified endpoint.
    var response = httpEndpoint->get("/chunkingSample");
    if (response is http:Response) {
        test:assertEquals(response.getJsonPayload(), response1);
    } else {
        test:assertFail(msg = "Failed to call the endpoint:");
    }
}
