module io.ballerina.quoter {
    requires java.sql;
    requires com.google.gson;
    requires io.ballerina.parser;
    requires io.ballerina.tools.api;
    requires commons.cli;
    requires org.slf4j;

    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.core;

    opens io.ballerinalang.quoter;
    opens io.ballerinalang.quoter.config;

    exports io.ballerinalang.quoter;
    exports io.ballerinalang.quoter.config;
}
