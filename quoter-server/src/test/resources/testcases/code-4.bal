import ballerina/io;
import ballerina/sql;
import ballerinax/mysql;
string dbUser = "root";
string dbPassword = "Test@123";function simpleQuery(mysql:Client mysqlClient) {
    io:println("------ Start Simple Query -------");
    stream<record{}, error> resultStream =
        mysqlClient->query("Select * from Customers");
    error? e = resultStream.forEach(function(record {} result) {
        io:println("Customer full details: ", result);
        io:println("Customer first name: ", result["FirstName"]);
        io:println("Customer last name: ", result["LastName"]);
    });
    if (e is error) {
        io:println("ForEach operation on the stream failed!", e);
    }    io:println("------ End Simple Query -------");
}function countRows(mysql:Client mysqlClient) {
    io:println("------ Start Count Total Rows -------");
    stream<record{}, error> resultStream =
        mysqlClient->query("Select count(*) as Total from Customers");
    record {|record {} value;|}|error? result = resultStream.next();
    if (result is record {|record {} value;|}) {
        io:println("Total rows in customer table : ", result.value["Total"]);
    } else if (result is error) {
        io:println("Next operation on the stream failed!", result);
    } else {
        io:println("Customer table is empty");
    }
    error? e = resultStream.close();    io:println("------ End Count Total Rows -------");
}
type Customer record {|
    int customerId;
    string lastName;
    string firstName;
    int registrationId;
    float creditLimit;
    string country;
|};function typedQuery(mysql:Client mysqlClient) {
    io:println("------ Start Query With Type Description -------");
    stream<record{}, error> resultStream =
        mysqlClient->query("Select * from Customers", Customer);
    stream<Customer, sql:Error> customerStream =
        <stream<Customer, sql:Error>>resultStream;
    error? e = customerStream.forEach(function(Customer customer) {
        io:println(customer);
    });
    if (e is error) {
       io:println(e);
    }    io:println("------ End Query With Type Description -------");
}
function initializeTable() returns sql:Error? {
    mysql:Client mysqlClient = check new (user = dbUser, password = dbPassword);
    sql:ExecutionResult result =
        check mysqlClient->execute("CREATE DATABASE IF NOT EXISTS MYSQL_BBE");
    result = check mysqlClient->execute("DROP TABLE IF EXISTS "+
        "MYSQL_BBE.Customers");
    result = check mysqlClient->execute("CREATE TABLE IF NOT EXISTS " +
        "MYSQL_BBE.Customers(customerId INTEGER " +
        "NOT NULL AUTO_INCREMENT, FirstName  VARCHAR(300), LastName  " +
        "VARCHAR(300), RegistrationID INTEGER," +
        "CreditLimit DOUBLE, Country  VARCHAR(300), PRIMARY KEY (CustomerId))");
    result = check mysqlClient->execute("INSERT INTO MYSQL_BBE.Customers "+
        "(FirstName,LastName,RegistrationID," +
        "CreditLimit,Country) VALUES ('Peter', 'Stuart', 1, 5000.75, 'USA')");
    result = check mysqlClient->execute("INSERT INTO MYSQL_BBE.Customers "+
        "(FirstName,LastName,RegistrationID," +
        "CreditLimit,Country) VALUES ('Dan', 'Brown', 2, 10000, 'UK')");
    check mysqlClient.close();
}
public function main() {
    sql:Error? err = initializeTable();    if (err is sql:Error) {
        io:println("Sample data initialization failed!");
        io:println(err);
    } else {
        mysql:Client|sql:Error mysqlClient = new (user = dbUser,
            password = dbPassword, database = "MYSQL_BBE");
        if (mysqlClient is mysql:Client) {
            simpleQuery(mysqlClient);
            countRows(mysqlClient);
            typedQuery(mysqlClient);
            io:println("Queried the database successfully!");
            sql:Error? e = mysqlClient.close();        } else {
            io:println("MySQL Client initialization for " +
                "querying data failed!", mysqlClient);
        }
    }
}
