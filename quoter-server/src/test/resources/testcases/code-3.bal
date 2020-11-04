import ballerina/io;function getAccountBalance(int accountID) returns int|error {
    if (accountID < 0) {
        return error("Invalid account ID", accountID = accountID);
    } else if (accountID > 100) {
        return error("Account not found", accountID = accountID);
    }
    return 600;
}
public function main() {
    error simpleError = error("Simple error occurred");
    io:println("Error: ", simpleError.message());    int|error result = getAccountBalance(-1);
    if (result is int) {
        io:println("Account Balance: ", result);
    } else {
        io:println("Error: ", result.message(),
                    ", Account ID: ", result.detail()["accountID"]);
        error displayError = error("Failed to get account balance", result);
        error? cause = displayError.cause();
        if (cause is error) {
            io:println("Caused by: ", cause.message());
        } else {
            io:println("Error cause not provided.");
        }
    }
}
