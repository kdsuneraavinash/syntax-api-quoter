module io.quoter.application.server {
    requires java.sql;
    requires org.slf4j;
    requires io.ballerina.quoter;
    requires io.ballerina.parser;

    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;

    exports io.quoter.application.server;
}
