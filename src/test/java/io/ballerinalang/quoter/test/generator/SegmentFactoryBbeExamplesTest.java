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

package io.ballerinalang.quoter.test.generator;

import io.ballerinalang.quoter.test.AbstractQuoterTest;
import org.testng.annotations.Test;

/**
 * Test bbe examples to segment conversion.
 */
public class SegmentFactoryBbeExamplesTest extends AbstractQuoterTest {
    @Test
    public void testAccessMutateJavaFields() {
        testAssertionFiles("bbe-examples", "access_mutate_java_fields");
    }

    @Test
    public void testAnonymousFunctions() {
        testAssertionFiles("bbe-examples", "anonymous_functions");
    }

    @Test
    public void testAnonymousRecords() {
        testAssertionFiles("bbe-examples", "anonymous_records");
    }

    @Test
    public void testAnyType() {
        testAssertionFiles("bbe-examples", "any_type");
    }

    @Test
    public void testAnyTypeTest() {
        testAssertionFiles("bbe-examples", "any_type_test");
    }

    @Test
    public void testAnydataType() {
        testAssertionFiles("bbe-examples", "anydata_type");
    }

    @Test
    public void testArrayBindingPattern() {
        testAssertionFiles("bbe-examples", "array_binding_pattern");
    }

    @Test
    public void testArrays() {
        testAssertionFiles("bbe-examples", "arrays");
    }

    @Test
    public void testAsync() {
        testAssertionFiles("bbe-examples", "async");
    }

    @Test
    public void testAsyncTest() {
        testAssertionFiles("bbe-examples", "async_test");
    }

    @Test
    public void testBallerinaToOpenapi() {
        testAssertionFiles("bbe-examples", "ballerina_to_openapi");
    }

    @Test
    public void testBallerinaToOpenapiTest() {
        testAssertionFiles("bbe-examples", "ballerina_to_openapi_test");
    }

    @Test
    public void testBasePathAndPath() {
        testAssertionFiles("bbe-examples", "base_path_and_path");
    }

    @Test
    public void testBasePathAndPathTest() {
        testAssertionFiles("bbe-examples", "base_path_and_path_test");
    }

    @Test
    public void testBasicDocumentation() {
        testAssertionFiles("bbe-examples", "basic_documentation");
    }

    @Test
    public void testBasicHttpsListener() {
        testAssertionFiles("bbe-examples", "basic_https_listener");
    }

    @Test
    public void testBasicHttpsListenerClientTest() {
        testAssertionFiles("bbe-examples", "basic_https_listener_client_test");
    }

    @Test
    public void testBinaryBitwiseExpressions() {
        testAssertionFiles("bbe-examples", "binary_bitwise_expressions");
    }

    @Test
    public void testByteIo() {
        testAssertionFiles("bbe-examples", "byte_io");
    }

    @Test
    public void testByteType() {
        testAssertionFiles("bbe-examples", "byte_type");
    }

    @Test
    public void testCache() {
        testAssertionFiles("bbe-examples", "cache");
    }

    @Test
    public void testCacheTest() {
        testAssertionFiles("bbe-examples", "cache_test");
    }

    @Test
    public void testCharacterIo() {
        testAssertionFiles("bbe-examples", "character_io");
    }

    @Test
    public void testCheck() {
        testAssertionFiles("bbe-examples", "check");
    }

    @Test
    public void testCheckpanic() {
        testAssertionFiles("bbe-examples", "checkpanic");
    }

    @Test
    public void testClassDefinition() {
        testAssertionFiles("bbe-examples", "class_definition");
    }

    @Test
    public void testClone() {
        testAssertionFiles("bbe-examples", "clone");
    }

    @Test
    public void testClosures() {
        testAssertionFiles("bbe-examples", "closures");
    }

    @Test
    public void testCompoundAssignmentOperators() {
        testAssertionFiles("bbe-examples", "compound_assignment_operators");
    }

    @Test
    public void testConfigApi() {
        testAssertionFiles("bbe-examples", "config_api");
    }

    @Test
    public void testConfigApiTest() {
        testAssertionFiles("bbe-examples", "config_api_test");
    }

    @Test
    public void testConstants() {
        testAssertionFiles("bbe-examples", "constants");
    }

    @Test
    public void testContentBasedRouting() {
        testAssertionFiles("bbe-examples", "content_based_routing");
    }

    @Test
    public void testContentBasedRoutingTest() {
        testAssertionFiles("bbe-examples", "content_based_routing_test");
    }

    @Test
    public void testCookieServer() {
        testAssertionFiles("bbe-examples", "cookie_server");
    }

    @Test
    public void testCounterMetrics() {
        testAssertionFiles("bbe-examples", "counter_metrics");
    }

    @Test
    public void testCounterMetricsTest() {
        testAssertionFiles("bbe-examples", "counter_metrics_test");
    }

    @Test
    public void testCreateJavaObjects() {
        testAssertionFiles("bbe-examples", "create_java_objects");
    }

    @Test
    public void testCrypto() {
        testAssertionFiles("bbe-examples", "crypto");
    }

    @Test
    public void testCryptoTest() {
        testAssertionFiles("bbe-examples", "crypto_test");
    }

    @Test
    public void testCsvIo() {
        testAssertionFiles("bbe-examples", "csv_io");
    }

    @Test
    public void testDataIo() {
        testAssertionFiles("bbe-examples", "data_io");
    }

    @Test
    public void testDeprecation() {
        testAssertionFiles("bbe-examples", "deprecation");
    }

    @Test
    public void testDifferentPayloadTypes() {
        testAssertionFiles("bbe-examples", "different_payload_types");
    }

    @Test
    public void testDirectoryListener() {
        testAssertionFiles("bbe-examples", "directory_listener");
    }

    @Test
    public void testElvisOperator() {
        testAssertionFiles("bbe-examples", "elvis_operator");
    }

    @Test
    public void testEnums() {
        testAssertionFiles("bbe-examples", "enums");
    }

    @Test
    public void testEquality() {
        testAssertionFiles("bbe-examples", "equality");
    }

    @Test
    public void testErrorDestructureBindingPattern() {
        testAssertionFiles("bbe-examples", "error_destructure_binding_pattern");
    }

    @Test
    public void testErrorHandling() {
        testAssertionFiles("bbe-examples", "error_handling");
    }

    @Test
    public void testErrorHandlingInSinglePlace() {
        testAssertionFiles("bbe-examples", "error_handling_in_single_place");
    }

    @Test
    public void testExpressionBodiedFunctions() {
        testAssertionFiles("bbe-examples", "expression_bodied_functions");
    }

    @Test
    public void testFail() {
        testAssertionFiles("bbe-examples", "fail");
    }

    @Test
    public void testFailTest() {
        testAssertionFiles("bbe-examples", "fail_test");
    }

    @Test
    public void testFile() {
        testAssertionFiles("bbe-examples", "file");
    }

    @Test
    public void testFilepath() {
        testAssertionFiles("bbe-examples", "filepath");
    }

    @Test
    public void testFilepathTest() {
        testAssertionFiles("bbe-examples", "filepath_test");
    }

    @Test
    public void testForeach() {
        testAssertionFiles("bbe-examples", "foreach");
    }

    @Test
    public void testFork() {
        testAssertionFiles("bbe-examples", "fork");
    }

    @Test
    public void testFunctionPointers() {
        testAssertionFiles("bbe-examples", "function_pointers");
    }

    @Test
    public void testFunctionPointersTest() {
        testAssertionFiles("bbe-examples", "function_pointers_test");
    }

    @Test
    public void testFunctionalIteration() {
        testAssertionFiles("bbe-examples", "functional_iteration");
    }

    @Test
    public void testFunctions() {
        testAssertionFiles("bbe-examples", "functions");
    }

    @Test
    public void testFunctionsWithDefaultableParameters() {
        testAssertionFiles("bbe-examples", "functions_with_defaultable_parameters");
    }

    @Test
    public void testFunctionsWithRequiredParameters() {
        testAssertionFiles("bbe-examples", "functions_with_required_parameters");
    }

    @Test
    public void testFunctionsWithRestParameter() {
        testAssertionFiles("bbe-examples", "functions_with_rest_parameter");
    }

    @Test
    public void testGaugeMetrics() {
        testAssertionFiles("bbe-examples", "gauge_metrics");
    }

    @Test
    public void testGaugeMetricsTest() {
        testAssertionFiles("bbe-examples", "gauge_metrics_test");
    }

    @Test
    public void testGrpcBidirectionalStreamingService() {
        testAssertionFiles("bbe-examples", "grpc_bidirectional_streaming_service");
    }

    @Test
    public void testGrpcBidirectionalStreamingServiceClient() {
        testAssertionFiles("bbe-examples", "grpc_bidirectional_streaming_service_client");
    }

    @Test
    public void testGrpcBidirectionalStreamingTest() {
        testAssertionFiles("bbe-examples", "grpc_bidirectional_streaming_test");
    }

    @Test
    public void testGrpcClientStreamingService() {
        testAssertionFiles("bbe-examples", "grpc_client_streaming_service");
    }

    @Test
    public void testGrpcClientStreamingServiceClient() {
        testAssertionFiles("bbe-examples", "grpc_client_streaming_service_client");
    }

    @Test
    public void testGrpcClientStreamingTest() {
        testAssertionFiles("bbe-examples", "grpc_client_streaming_test");
    }

    @Test
    public void testGrpcSecuredUnaryService() {
        testAssertionFiles("bbe-examples", "grpc_secured_unary_service");
    }

    @Test
    public void testGrpcSecuredUnaryServiceClient() {
        testAssertionFiles("bbe-examples", "grpc_secured_unary_service_client");
    }

    @Test
    public void testGrpcSecuredUnaryTest() {
        testAssertionFiles("bbe-examples", "grpc_secured_unary_test");
    }

    @Test
    public void testGrpcServerStreamingService() {
        testAssertionFiles("bbe-examples", "grpc_server_streaming_service");
    }

    @Test
    public void testGrpcServerStreamingServiceClient() {
        testAssertionFiles("bbe-examples", "grpc_server_streaming_service_client");
    }

    @Test
    public void testGrpcServerStreamingTest() {
        testAssertionFiles("bbe-examples", "grpc_server_streaming_test");
    }

    @Test
    public void testGrpcUnaryBlockingService() {
        testAssertionFiles("bbe-examples", "grpc_unary_blocking_service");
    }

    @Test
    public void testGrpcUnaryBlockingServiceClient() {
        testAssertionFiles("bbe-examples", "grpc_unary_blocking_service_client");
    }

    @Test
    public void testGrpcUnaryBlockingTest() {
        testAssertionFiles("bbe-examples", "grpc_unary_blocking_test");
    }

    @Test
    public void testGrpcUnaryNonBlockingService() {
        testAssertionFiles("bbe-examples", "grpc_unary_non_blocking_service");
    }

    @Test
    public void testGrpcUnaryNonBlockingServiceClient() {
        testAssertionFiles("bbe-examples", "grpc_unary_non_blocking_service_client");
    }

    @Test
    public void testGrpcUnaryNonBlockingTest() {
        testAssertionFiles("bbe-examples", "grpc_unary_non_blocking_test");
    }

    @Test
    public void testHeaderBasedRouting() {
        testAssertionFiles("bbe-examples", "header_based_routing");
    }

    @Test
    public void testHeaderBasedRoutingTest() {
        testAssertionFiles("bbe-examples", "header_based_routing_test");
    }

    @Test
    public void testHelloWorld() {
        testAssertionFiles("bbe-examples", "hello_world");
    }

    @Test
    public void testHelloWorldClient() {
        testAssertionFiles("bbe-examples", "hello_world_client");
    }

    @Test
    public void testHelloWorldClientTest() {
        testAssertionFiles("bbe-examples", "hello_world_client_test");
    }

    @Test
    public void testHelloWorldParallel() {
        testAssertionFiles("bbe-examples", "hello_world_parallel");
    }

    @Test
    public void testHelloWorldParallelTest() {
        testAssertionFiles("bbe-examples", "hello_world_parallel_test");
    }

    @Test
    public void testHelloWorldService() {
        testAssertionFiles("bbe-examples", "hello_world_service");
    }

    @Test
    public void testHelloWorldServiceTest() {
        testAssertionFiles("bbe-examples", "hello_world_service_test");
    }

    @Test
    public void testHttp100Continue() {
        testAssertionFiles("bbe-examples", "http_100_continue");
    }

    @Test
    public void testHttp100ContinueTest() {
        testAssertionFiles("bbe-examples", "http_100_continue_test");
    }

    @Test
    public void testHttp11To20ProtocolSwitch() {
        testAssertionFiles("bbe-examples", "http_1_1_to_2_0_protocol_switch");
    }

    @Test
    public void testHttp11To20ProtocolSwitchTest() {
        testAssertionFiles("bbe-examples", "http_1_1_to_2_0_protocol_switch_test");
    }

    @Test
    public void testHttp20Service() {
        testAssertionFiles("bbe-examples", "http_2_0_service");
    }

    @Test
    public void testHttpAccessLogs() {
        testAssertionFiles("bbe-examples", "http_access_logs");
    }

    @Test
    public void testHttpAccessLogsTest() {
        testAssertionFiles("bbe-examples", "http_access_logs_test");
    }

    @Test
    public void testHttpCachingClient() {
        testAssertionFiles("bbe-examples", "http_caching_client");
    }

    @Test
    public void testHttpCachingClientTest() {
        testAssertionFiles("bbe-examples", "http_caching_client_test");
    }

    @Test
    public void testHttpCircuitBreaker() {
        testAssertionFiles("bbe-examples", "http_circuit_breaker");
    }

    @Test
    public void testHttpCircuitBreakerTest() {
        testAssertionFiles("bbe-examples", "http_circuit_breaker_test");
    }

    @Test
    public void testHttpClient1() {
        testAssertionFiles("bbe-examples", "http_client_1");
    }

    @Test
    public void testHttpClient2() {
        testAssertionFiles("bbe-examples", "http_client_2");
    }

    @Test
    public void testHttpClientDataBinding() {
        testAssertionFiles("bbe-examples", "http_client_data_binding");
    }

    @Test
    public void testHttpClientDataBindingTest() {
        testAssertionFiles("bbe-examples", "http_client_data_binding_test");
    }

    @Test
    public void testHttpClientEndpoint() {
        testAssertionFiles("bbe-examples", "http_client_endpoint");
    }

    @Test
    public void testHttpClientEndpointTest() {
        testAssertionFiles("bbe-examples", "http_client_endpoint_test");
    }

    @Test
    public void testHttpCompression() {
        testAssertionFiles("bbe-examples", "http_compression");
    }

    @Test
    public void testHttpCompressionTest() {
        testAssertionFiles("bbe-examples", "http_compression_test");
    }

    @Test
    public void testHttpCors() {
        testAssertionFiles("bbe-examples", "http_cors");
    }

    @Test
    public void testHttpCorsTest() {
        testAssertionFiles("bbe-examples", "http_cors_test");
    }

    @Test
    public void testHttpDataBinding() {
        testAssertionFiles("bbe-examples", "http_data_binding");
    }

    @Test
    public void testHttpDataBindingTest() {
        testAssertionFiles("bbe-examples", "http_data_binding_test");
    }

    @Test
    public void testHttpDisableChunking() {
        testAssertionFiles("bbe-examples", "http_disable_chunking");
    }

    @Test
    public void testHttpDisableChunkingTest() {
        testAssertionFiles("bbe-examples", "http_disable_chunking_test");
    }

    @Test
    public void testHttpFailover() {
        testAssertionFiles("bbe-examples", "http_failover");
    }

    @Test
    public void testHttpFailoverTest() {
        testAssertionFiles("bbe-examples", "http_failover_test");
    }

    @Test
    public void testHttpFilters() {
        testAssertionFiles("bbe-examples", "http_filters");
    }

    @Test
    public void testHttpFiltersTest() {
        testAssertionFiles("bbe-examples", "http_filters_test");
    }

    @Test
    public void testHttpLoadBalancer() {
        testAssertionFiles("bbe-examples", "http_load_balancer");
    }

    @Test
    public void testHttpLoadBalancerTest() {
        testAssertionFiles("bbe-examples", "http_load_balancer_test");
    }

    @Test
    public void testHttpRedirects() {
        testAssertionFiles("bbe-examples", "http_redirects");
    }

    @Test
    public void testHttpRedirectsTest() {
        testAssertionFiles("bbe-examples", "http_redirects_test");
    }

    @Test
    public void testHttpRetry() {
        testAssertionFiles("bbe-examples", "http_retry");
    }

    @Test
    public void testHttpRetryTest() {
        testAssertionFiles("bbe-examples", "http_retry_test");
    }

    @Test
    public void testHttpStreaming() {
        testAssertionFiles("bbe-examples", "http_streaming");
    }

    @Test
    public void testHttpTimeout() {
        testAssertionFiles("bbe-examples", "http_timeout");
    }

    @Test
    public void testHttpTimeoutTest() {
        testAssertionFiles("bbe-examples", "http_timeout_test");
    }

    @Test
    public void testHttpToWebsocketUpgrade() {
        testAssertionFiles("bbe-examples", "http_to_websocket_upgrade");
    }

    @Test
    public void testHttpToWebsocketUpgradeTest() {
        testAssertionFiles("bbe-examples", "http_to_websocket_upgrade_test");
    }

    @Test
    public void testHttpTraceLogs() {
        testAssertionFiles("bbe-examples", "http_trace_logs");
    }

    @Test
    public void testHttpsClient() {
        testAssertionFiles("bbe-examples", "https_client");
    }

    @Test
    public void testHttpsListener() {
        testAssertionFiles("bbe-examples", "https_listener");
    }

    @Test
    public void testHttpsListenerTest() {
        testAssertionFiles("bbe-examples", "https_listener_test");
    }

    @Test
    public void testHub() {
        testAssertionFiles("bbe-examples", "hub");
    }

    @Test
    public void testIfElse() {
        testAssertionFiles("bbe-examples", "if_else");
    }

    @Test
    public void testImmutableValues() {
        testAssertionFiles("bbe-examples", "immutable_values");
    }

    @Test
    public void testInvokeJavaMethods() {
        testAssertionFiles("bbe-examples", "invoke_java_methods");
    }

    @Test
    public void testIsolatedFunctions() {
        testAssertionFiles("bbe-examples", "isolated_functions");
    }

    @Test
    public void testIterableObjects() {
        testAssertionFiles("bbe-examples", "iterable_objects");
    }

    @Test
    public void testJavaArrays() {
        testAssertionFiles("bbe-examples", "java_arrays");
    }

    @Test
    public void testJavaExceptions() {
        testAssertionFiles("bbe-examples", "java_exceptions");
    }

    @Test
    public void testJavaVarargs() {
        testAssertionFiles("bbe-examples", "java_varargs");
    }

    @Test
    public void testJdbcBatchExecuteOperation() {
        testAssertionFiles("bbe-examples", "jdbc_batch_execute_operation");
    }

    @Test
    public void testJdbcComplexTypeQueries() {
        testAssertionFiles("bbe-examples", "jdbc_complex_type_queries");
    }

    @Test
    public void testJdbcExecuteOperation() {
        testAssertionFiles("bbe-examples", "jdbc_execute_operation");
    }

    @Test
    public void testJdbcInitOptions() {
        testAssertionFiles("bbe-examples", "jdbc_init_options");
    }

    @Test
    public void testJdbcParameterizedQuery() {
        testAssertionFiles("bbe-examples", "jdbc_parameterized_query");
    }

    @Test
    public void testJdbcQueryOperation() {
        testAssertionFiles("bbe-examples", "jdbc_query_operation");
    }

    @Test
    public void testJson() {
        testAssertionFiles("bbe-examples", "json");
    }

    @Test
    public void testJsonAccess() {
        testAssertionFiles("bbe-examples", "json_access");
    }

    @Test
    public void testJsonArrays() {
        testAssertionFiles("bbe-examples", "json_arrays");
    }

    @Test
    public void testJsonCsv() {
        testAssertionFiles("bbe-examples", "json_csv");
    }

    @Test
    public void testJsonIo() {
        testAssertionFiles("bbe-examples", "json_io");
    }

    @Test
    public void testJsonObjects() {
        testAssertionFiles("bbe-examples", "json_objects");
    }

    @Test
    public void testJsonRecordMapConversion() {
        testAssertionFiles("bbe-examples", "json_record_map_conversion");
    }

    @Test
    public void testJsonToXmlConversion() {
        testAssertionFiles("bbe-examples", "json_to_xml_conversion");
    }

    @Test
    public void testJwtIssueValidate() {
        testAssertionFiles("bbe-examples", "jwt_issue_validate");
    }

    @Test
    public void testJwtIssueValidateTest() {
        testAssertionFiles("bbe-examples", "jwt_issue_validate_test");
    }

    @Test
    public void testJwtMockServer() {
        testAssertionFiles("bbe-examples", "jwt_mock_server");
    }

    @Test
    public void testKafkaAuthenticationSaslPlainConsumer() {
        testAssertionFiles("bbe-examples", "kafka_authentication_sasl_plain_consumer");
    }

    @Test
    public void testKafkaAuthenticationSaslPlainProducer() {
        testAssertionFiles("bbe-examples", "kafka_authentication_sasl_plain_producer");
    }

    @Test
    public void testKafkaConsumerClient() {
        testAssertionFiles("bbe-examples", "kafka_consumer_client");
    }

    @Test
    public void testKafkaConsumerGroupService() {
        testAssertionFiles("bbe-examples", "kafka_consumer_group_service");
    }

    @Test
    public void testKafkaConsumerService() {
        testAssertionFiles("bbe-examples", "kafka_consumer_service");
    }

    @Test
    public void testKafkaProducer() {
        testAssertionFiles("bbe-examples", "kafka_producer");
    }

    @Test
    public void testKafkaProducerTransactional() {
        testAssertionFiles("bbe-examples", "kafka_producer_transactional");
    }

    @Test
    public void testLength() {
        testAssertionFiles("bbe-examples", "length");
    }

    @Test
    public void testLetExpression() {
        testAssertionFiles("bbe-examples", "let_expression");
    }

    @Test
    public void testLocalTransactions() {
        testAssertionFiles("bbe-examples", "local_transactions");
    }

    @Test
    public void testLocalTransactionsWithHandlers() {
        testAssertionFiles("bbe-examples", "local_transactions_with_handlers");
    }

    @Test
    public void testLocks() {
        testAssertionFiles("bbe-examples", "locks");
    }

    @Test
    public void testLogApi() {
        testAssertionFiles("bbe-examples", "log_api");
    }

    @Test
    public void testLogApiTest() {
        testAssertionFiles("bbe-examples", "log_api_test");
    }

    @Test
    public void testMaps() {
        testAssertionFiles("bbe-examples", "maps");
    }

    @Test
    public void testMatch() {
        testAssertionFiles("bbe-examples", "match");
    }

    @Test
    public void testMathFunctions() {
        testAssertionFiles("bbe-examples", "math_functions");
    }

    @Test
    public void testModules() {
        testAssertionFiles("bbe-examples", "modules");
    }

    @Test
    public void testMutualSslService() {
        testAssertionFiles("bbe-examples", "mutual_ssl_service");
    }

    @Test
    public void testMutualSslTest() {
        testAssertionFiles("bbe-examples", "mutual_ssl_test");
    }

    @Test
    public void testMysqlBatchExecuteOperation() {
        testAssertionFiles("bbe-examples", "mysql_batch_execute_operation");
    }

    @Test
    public void testMysqlBatchExecuteOperationTest() {
        testAssertionFiles("bbe-examples", "mysql_batch_execute_operation_test");
    }

    @Test
    public void testMysqlCallStoredProcedures() {
        testAssertionFiles("bbe-examples", "mysql_call_stored_procedures");
    }

    @Test
    public void testMysqlCallStoredProceduresTest() {
        testAssertionFiles("bbe-examples", "mysql_call_stored_procedures_test");
    }

    @Test
    public void testMysqlComplexTypeQueries() {
        testAssertionFiles("bbe-examples", "mysql_complex_type_queries");
    }

    @Test
    public void testMysqlComplexTypeQueriesTest() {
        testAssertionFiles("bbe-examples", "mysql_complex_type_queries_test");
    }

    @Test
    public void testMysqlExecuteOperation() {
        testAssertionFiles("bbe-examples", "mysql_execute_operation");
    }

    @Test
    public void testMysqlExecuteOperationTest() {
        testAssertionFiles("bbe-examples", "mysql_execute_operation_test");
    }

    @Test
    public void testMysqlInitOptions() {
        testAssertionFiles("bbe-examples", "mysql_init_options");
    }

    @Test
    public void testMysqlInitOptionsTest() {
        testAssertionFiles("bbe-examples", "mysql_init_options_test");
    }

    @Test
    public void testMysqlParameterizedQuery() {
        testAssertionFiles("bbe-examples", "mysql_parameterized_query");
    }

    @Test
    public void testMysqlParameterizedQueryTest() {
        testAssertionFiles("bbe-examples", "mysql_parameterized_query_test");
    }

    @Test
    public void testMysqlQueryOperation() {
        testAssertionFiles("bbe-examples", "mysql_query_operation");
    }

    @Test
    public void testMysqlQueryOperationTest() {
        testAssertionFiles("bbe-examples", "mysql_query_operation_test");
    }

    @Test
    public void testNeverType() {
        testAssertionFiles("bbe-examples", "never_type");
    }

    @Test
    public void testNonTransactionRetry() {
        testAssertionFiles("bbe-examples", "non_transaction_retry");
    }

    @Test
    public void testNonTransactionRetryTest() {
        testAssertionFiles("bbe-examples", "non_transaction_retry_test");
    }

    @Test
    public void testObjectAssignability() {
        testAssertionFiles("bbe-examples", "object_assignability");
    }

    @Test
    public void testObjectConstructorExpression() {
        testAssertionFiles("bbe-examples", "object_constructor_expression");
    }

    @Test
    public void testObjectFinalFields() {
        testAssertionFiles("bbe-examples", "object_final_fields");
    }

    @Test
    public void testObjectInitializer() {
        testAssertionFiles("bbe-examples", "object_initializer");
    }

    @Test
    public void testObjectMethods() {
        testAssertionFiles("bbe-examples", "object_methods");
    }

    @Test
    public void testObjectType() {
        testAssertionFiles("bbe-examples", "object_type");
    }

    @Test
    public void testObjectTypeReference() {
        testAssertionFiles("bbe-examples", "object_type_reference");
    }

    @Test
    public void testOptionalFieldAccess() {
        testAssertionFiles("bbe-examples", "optional_field_access");
    }

    @Test
    public void testOptionalType() {
        testAssertionFiles("bbe-examples", "optional_type");
    }

    @Test
    public void testOptionalTypeTest() {
        testAssertionFiles("bbe-examples", "optional_type_test");
    }

    @Test
    public void testOrderMgmtService() {
        testAssertionFiles("bbe-examples", "order_mgmt_service");
    }

    @Test
    public void testOverloadedMethodsConstructors() {
        testAssertionFiles("bbe-examples", "overloaded_methods_constructors");
    }

    @Test
    public void testPanic() {
        testAssertionFiles("bbe-examples", "panic");
    }

    @Test
    public void testPassthrough() {
        testAssertionFiles("bbe-examples", "passthrough");
    }

    @Test
    public void testPublisher1() {
        testAssertionFiles("bbe-examples", "publisher_1");
    }

    @Test
    public void testPublisher2() {
        testAssertionFiles("bbe-examples", "publisher_2");
    }

    @Test
    public void testPublisher3() {
        testAssertionFiles("bbe-examples", "publisher_3");
    }

    @Test
    public void testPublisher4() {
        testAssertionFiles("bbe-examples", "publisher_4");
    }

    @Test
    public void testPublisher5() {
        testAssertionFiles("bbe-examples", "publisher_5");
    }

    @Test
    public void testPublisher6() {
        testAssertionFiles("bbe-examples", "publisher_6");
    }

    @Test
    public void testPublisher7() {
        testAssertionFiles("bbe-examples", "publisher_7");
    }

    @Test
    public void testPublisher8() {
        testAssertionFiles("bbe-examples", "publisher_8");
    }

    @Test
    public void testQueryAction() {
        testAssertionFiles("bbe-examples", "query_action");
    }

    @Test
    public void testQueryExpression() {
        testAssertionFiles("bbe-examples", "query_expression");
    }

    @Test
    public void testQueryExpressionToStream() {
        testAssertionFiles("bbe-examples", "query_expression_to_stream");
    }

    @Test
    public void testQueryExpressionToString() {
        testAssertionFiles("bbe-examples", "query_expression_to_string");
    }

    @Test
    public void testQueryExpressionToTable() {
        testAssertionFiles("bbe-examples", "query_expression_to_table");
    }

    @Test
    public void testQueryExpressionToXml() {
        testAssertionFiles("bbe-examples", "query_expression_to_xml");
    }

    @Test
    public void testQueryJoin() {
        testAssertionFiles("bbe-examples", "query_join");
    }

    @Test
    public void testQueryPathMatrixParam() {
        testAssertionFiles("bbe-examples", "query_path_matrix_param");
    }

    @Test
    public void testQueueGroup() {
        testAssertionFiles("bbe-examples", "queue-group");
    }

    @Test
    public void testQuotedIdentifiers() {
        testAssertionFiles("bbe-examples", "quoted_identifiers");
    }

    @Test
    public void testRabbitmqConsumer() {
        testAssertionFiles("bbe-examples", "rabbitmq_consumer");
    }

    @Test
    public void testRabbitmqConsumerWithClientAcknowledgement() {
        testAssertionFiles("bbe-examples", "rabbitmq_consumer_with_client_acknowledgement");
    }

    @Test
    public void testRabbitmqConsumerWithDataBinding() {
        testAssertionFiles("bbe-examples", "rabbitmq_consumer_with_data_binding");
    }

    @Test
    public void testRabbitmqConsumerWithQosSettings() {
        testAssertionFiles("bbe-examples", "rabbitmq_consumer_with_qos_settings");
    }

    @Test
    public void testRabbitmqProducer() {
        testAssertionFiles("bbe-examples", "rabbitmq_producer");
    }

    @Test
    public void testRabbitmqTransactionConsumer() {
        testAssertionFiles("bbe-examples", "rabbitmq_transaction_consumer");
    }

    @Test
    public void testRabbitmqTransactionProducer() {
        testAssertionFiles("bbe-examples", "rabbitmq_transaction_producer");
    }

    @Test
    public void testRangeExpressions() {
        testAssertionFiles("bbe-examples", "range_expressions");
    }

    @Test
    public void testRawTemplate() {
        testAssertionFiles("bbe-examples", "raw_template");
    }

    @Test
    public void testReadonlyObjects() {
        testAssertionFiles("bbe-examples", "readonly_objects");
    }

    @Test
    public void testReadonlyType() {
        testAssertionFiles("bbe-examples", "readonly_type");
    }

    @Test
    public void testRecordBindingPattern() {
        testAssertionFiles("bbe-examples", "record_binding_pattern");
    }

    @Test
    public void testRecordIo() {
        testAssertionFiles("bbe-examples", "record_io");
    }

    @Test
    public void testRecordIoTest() {
        testAssertionFiles("bbe-examples", "record_io_test");
    }

    @Test
    public void testRecordOptionalFields() {
        testAssertionFiles("bbe-examples", "record_optional_fields");
    }

    @Test
    public void testRecordReadonlyFields() {
        testAssertionFiles("bbe-examples", "record_readonly_fields");
    }

    @Test
    public void testRecordTypeReference() {
        testAssertionFiles("bbe-examples", "record_type_reference");
    }

    @Test
    public void testRecords() {
        testAssertionFiles("bbe-examples", "records");
    }

    @Test
    public void testRequestWithMultiparts() {
        testAssertionFiles("bbe-examples", "request_with_multiparts");
    }

    @Test
    public void testRequestWithMultipartsTest() {
        testAssertionFiles("bbe-examples", "request_with_multiparts_test");
    }

    @Test
    public void testResponseWithMultiparts() {
        testAssertionFiles("bbe-examples", "response_with_multiparts");
    }

    @Test
    public void testResponseWithMultipartsTest() {
        testAssertionFiles("bbe-examples", "response_with_multiparts_test");
    }

    @Test
    public void testRestrictByMediaType() {
        testAssertionFiles("bbe-examples", "restrict_by_media_type");
    }

    @Test
    public void testRetryTransactions() {
        testAssertionFiles("bbe-examples", "retry_transactions");
    }

    @Test
    public void testRetryTransactionsTest() {
        testAssertionFiles("bbe-examples", "retry_transactions_test");
    }

    @Test
    public void testSecuredClientWithBasicAuth() {
        testAssertionFiles("bbe-examples", "secured_client_with_basic_auth");
    }

    @Test
    public void testSecuredClientWithBasicAuthTest() {
        testAssertionFiles("bbe-examples", "secured_client_with_basic_auth_test");
    }

    @Test
    public void testSecuredClientWithJwtAuth() {
        testAssertionFiles("bbe-examples", "secured_client_with_jwt_auth");
    }

    @Test
    public void testSecuredClientWithJwtAuthTest() {
        testAssertionFiles("bbe-examples", "secured_client_with_jwt_auth_test");
    }

    @Test
    public void testSecuredClientWithOauth2() {
        testAssertionFiles("bbe-examples", "secured_client_with_oauth2");
    }

    @Test
    public void testSecuredServiceWithBasicAuth1() {
        testAssertionFiles("bbe-examples", "secured_service_with_basic_auth_1");
    }

    @Test
    public void testSecuredServiceWithBasicAuth2() {
        testAssertionFiles("bbe-examples", "secured_service_with_basic_auth_2");
    }

    @Test
    public void testSecuredServiceWithBasicAuthTest() {
        testAssertionFiles("bbe-examples", "secured_service_with_basic_auth_test");
    }

    @Test
    public void testSecuredServiceWithJwtAuth1() {
        testAssertionFiles("bbe-examples", "secured_service_with_jwt_auth_1");
    }

    @Test
    public void testSecuredServiceWithJwtAuth2() {
        testAssertionFiles("bbe-examples", "secured_service_with_jwt_auth_2");
    }

    @Test
    public void testSecuredServiceWithJwtAuthTest() {
        testAssertionFiles("bbe-examples", "secured_service_with_jwt_auth_test");
    }

    @Test
    public void testSecuredServiceWithLdap() {
        testAssertionFiles("bbe-examples", "secured_service_with_ldap");
    }

    @Test
    public void testSecuredServiceWithOauth2() {
        testAssertionFiles("bbe-examples", "secured_service_with_oauth2");
    }

    @Test
    public void testSendAndReceiveEmails() {
        testAssertionFiles("bbe-examples", "send_and_receive_emails");
    }

    @Test
    public void testShiftExpressions() {
        testAssertionFiles("bbe-examples", "shift_expressions");
    }

    @Test
    public void testSslClient() {
        testAssertionFiles("bbe-examples", "ssl_client");
    }

    @Test
    public void testStreams() {
        testAssertionFiles("bbe-examples", "streams");
    }

    @Test
    public void testStringTemplate() {
        testAssertionFiles("bbe-examples", "string_template");
    }

    @Test
    public void testStrings() {
        testAssertionFiles("bbe-examples", "strings");
    }

    @Test
    public void testSubscriber1() {
        testAssertionFiles("bbe-examples", "subscriber_1");
    }

    @Test
    public void testSubscriber2() {
        testAssertionFiles("bbe-examples", "subscriber_2");
    }

    @Test
    public void testSubscriber3() {
        testAssertionFiles("bbe-examples", "subscriber_3");
    }

    @Test
    public void testSubscriber4() {
        testAssertionFiles("bbe-examples", "subscriber_4");
    }

    @Test
    public void testSubscriber5() {
        testAssertionFiles("bbe-examples", "subscriber_5");
    }

    @Test
    public void testSubscriber6() {
        testAssertionFiles("bbe-examples", "subscriber_6");
    }

    @Test
    public void testSubscriber7() {
        testAssertionFiles("bbe-examples", "subscriber_7");
    }

    @Test
    public void testSubscriber8() {
        testAssertionFiles("bbe-examples", "subscriber_8");
    }

    @Test
    public void testSubscriberService() {
        testAssertionFiles("bbe-examples", "subscriber_service");
    }

    @Test
    public void testSubscriptionChangeClient() {
        testAssertionFiles("bbe-examples", "subscription_change_client");
    }

    @Test
    public void testTable() {
        testAssertionFiles("bbe-examples", "table");
    }

    @Test
    public void testTaintChecking() {
        testAssertionFiles("bbe-examples", "taint_checking");
    }

    @Test
    public void testTaskSchedulerAppointment() {
        testAssertionFiles("bbe-examples", "task_scheduler_appointment");
    }

    @Test
    public void testTaskSchedulerAppointmentTest() {
        testAssertionFiles("bbe-examples", "task_scheduler_appointment_test");
    }

    @Test
    public void testTaskSchedulerTimer() {
        testAssertionFiles("bbe-examples", "task_scheduler_timer");
    }

    @Test
    public void testTaskSchedulerTimerTest() {
        testAssertionFiles("bbe-examples", "task_scheduler_timer_test");
    }

    @Test
    public void testTaskServiceAppointment() {
        testAssertionFiles("bbe-examples", "task_service_appointment");
    }

    @Test
    public void testTaskServiceTimer() {
        testAssertionFiles("bbe-examples", "task_service_timer");
    }

    @Test
    public void testTcpSocketClient() {
        testAssertionFiles("bbe-examples", "tcp_socket_client");
    }

    @Test
    public void testTcpSocketListener() {
        testAssertionFiles("bbe-examples", "tcp_socket_listener");
    }

    @Test
    public void testTesterinaAssertions() {
        testAssertionFiles("bbe-examples", "testerina_assertions");
    }

    @Test
    public void testTesterinaBeforeAndAfterEach() {
        testAssertionFiles("bbe-examples", "testerina_before_and_after_each");
    }

    @Test
    public void testTesterinaBeforeAndAfterGroups() {
        testAssertionFiles("bbe-examples", "testerina_before_and_after_groups");
    }

    @Test
    public void testTesterinaBeforeAndAfterSuite() {
        testAssertionFiles("bbe-examples", "testerina_before_and_after_suite");
    }

    @Test
    public void testTesterinaBeforeAndAfterTest() {
        testAssertionFiles("bbe-examples", "testerina_before_and_after_test");
    }

    @Test
    public void testTesterinaDataDrivenTests() {
        testAssertionFiles("bbe-examples", "testerina_data_driven_tests");
    }

    @Test
    public void testTesterinaGroupTests() {
        testAssertionFiles("bbe-examples", "testerina_group_tests");
    }

    @Test
    public void testTesterinaGuaranteeTestExecutionOrder() {
        testAssertionFiles("bbe-examples", "testerina_guarantee_test_execution_order");
    }

    @Test
    public void testTesterinaMockingFunctionsMain() {
        testAssertionFiles("bbe-examples", "testerina_mocking_functions_main");
    }

    @Test
    public void testTesterinaMockingFunctionsTest() {
        testAssertionFiles("bbe-examples", "testerina_mocking_functions_test");
    }

    @Test
    public void testTesterinaMockingObjectsMain() {
        testAssertionFiles("bbe-examples", "testerina_mocking_objects_main");
    }

    @Test
    public void testTesterinaMockingObjectsTest() {
        testAssertionFiles("bbe-examples", "testerina_mocking_objects_test");
    }

    @Test
    public void testTheMainFunction() {
        testAssertionFiles("bbe-examples", "the_main_function");
    }

    @Test
    public void testTheMainFunctionTest() {
        testAssertionFiles("bbe-examples", "the_main_function_test");
    }

    @Test
    public void testThreadsAndStrands() {
        testAssertionFiles("bbe-examples", "threads_and_strands");
    }

    @Test
    public void testTime() {
        testAssertionFiles("bbe-examples", "time");
    }

    @Test
    public void testTimeTest() {
        testAssertionFiles("bbe-examples", "time_test");
    }

    @Test
    public void testTracing() {
        testAssertionFiles("bbe-examples", "tracing");
    }

    @Test
    public void testTracingTest() {
        testAssertionFiles("bbe-examples", "tracing_test");
    }

    @Test
    public void testTrap() {
        testAssertionFiles("bbe-examples", "trap");
    }

    @Test
    public void testTupleBindingPattern() {
        testAssertionFiles("bbe-examples", "tuple_binding_pattern");
    }

    @Test
    public void testTupleType() {
        testAssertionFiles("bbe-examples", "tuple_type");
    }

    @Test
    public void testTypeCast() {
        testAssertionFiles("bbe-examples", "type_cast");
    }

    @Test
    public void testTypeConversion() {
        testAssertionFiles("bbe-examples", "type_conversion");
    }

    @Test
    public void testTypeGuard() {
        testAssertionFiles("bbe-examples", "type_guard");
    }

    @Test
    public void testTypeTestExpression() {
        testAssertionFiles("bbe-examples", "type_test_expression");
    }

    @Test
    public void testUdpSocketClient() {
        testAssertionFiles("bbe-examples", "udp_socket_client");
    }

    @Test
    public void testUnionType() {
        testAssertionFiles("bbe-examples", "union_type");
    }

    @Test
    public void testUpgradeService() {
        testAssertionFiles("bbe-examples", "upgrade_service");
    }

    @Test
    public void testUrlEncodeDecode() {
        testAssertionFiles("bbe-examples", "url_encode_decode");
    }

    @Test
    public void testUrlEncodeDecodeTest() {
        testAssertionFiles("bbe-examples", "url_encode_decode_test");
    }

    @Test
    public void testUserDefinedError() {
        testAssertionFiles("bbe-examples", "user_defined_error");
    }

    @Test
    public void testValues() {
        testAssertionFiles("bbe-examples", "values");
    }

    @Test
    public void testVar() {
        testAssertionFiles("bbe-examples", "var");
    }

    @Test
    public void testVariables() {
        testAssertionFiles("bbe-examples", "variables");
    }

    @Test
    public void testWebsocketBasicSample() {
        testAssertionFiles("bbe-examples", "websocket_basic_sample");
    }

    @Test
    public void testWebsocketBasicSampleTest() {
        testAssertionFiles("bbe-examples", "websocket_basic_sample_test");
    }

    @Test
    public void testWebsocketChatApplication() {
        testAssertionFiles("bbe-examples", "websocket_chat_application");
    }

    @Test
    public void testWebsocketChatApplicationTest() {
        testAssertionFiles("bbe-examples", "websocket_chat_application_test");
    }

    @Test
    public void testWebsocketClient() {
        testAssertionFiles("bbe-examples", "websocket_client");
    }

    @Test
    public void testWebsocketCookie() {
        testAssertionFiles("bbe-examples", "websocket_cookie");
    }

    @Test
    public void testWebsocketFailover() {
        testAssertionFiles("bbe-examples", "websocket_failover");
    }

    @Test
    public void testWebsocketProxyServer() {
        testAssertionFiles("bbe-examples", "websocket_proxy_server");
    }

    @Test
    public void testWebsocketProxyServerTest() {
        testAssertionFiles("bbe-examples", "websocket_proxy_server_test");
    }

    @Test
    public void testWebsocketRetry() {
        testAssertionFiles("bbe-examples", "websocket_retry");
    }

    @Test
    public void testWebsocketService() {
        testAssertionFiles("bbe-examples", "websocket_service");
    }

    @Test
    public void testWebsocketService9094() {
        testAssertionFiles("bbe-examples", "websocket_service_9094");
    }

    @Test
    public void testWebsocketService9095() {
        testAssertionFiles("bbe-examples", "websocket_service_9095");
    }

    @Test
    public void testWhile() {
        testAssertionFiles("bbe-examples", "while");
    }

    @Test
    public void testWhileTest() {
        testAssertionFiles("bbe-examples", "while_test");
    }

    @Test
    public void testWorkerInteraction() {
        testAssertionFiles("bbe-examples", "worker_interaction");
    }

    @Test
    public void testWorkerInteractionTest() {
        testAssertionFiles("bbe-examples", "worker_interaction_test");
    }

    @Test
    public void testWorkerTest() {
        testAssertionFiles("bbe-examples", "worker_test");
    }

    @Test
    public void testWorkers() {
        testAssertionFiles("bbe-examples", "workers");
    }

    @Test
    public void testXml() {
        testAssertionFiles("bbe-examples", "xml");
    }

    @Test
    public void testXmlAccess() {
        testAssertionFiles("bbe-examples", "xml_access");
    }

    @Test
    public void testXmlAttributes() {
        testAssertionFiles("bbe-examples", "xml_attributes");
    }

    @Test
    public void testXmlAttributesTest() {
        testAssertionFiles("bbe-examples", "xml_attributes_test");
    }

    @Test
    public void testXmlFunctions() {
        testAssertionFiles("bbe-examples", "xml_functions");
    }

    @Test
    public void testXmlIo() {
        testAssertionFiles("bbe-examples", "xml_io");
    }

    @Test
    public void testXmlLiteral() {
        testAssertionFiles("bbe-examples", "xml_literal");
    }

    @Test
    public void testXmlNamespaces() {
        testAssertionFiles("bbe-examples", "xml_namespaces");
    }

    @Test
    public void testXsltTransformation() {
        testAssertionFiles("bbe-examples", "xslt_transformation");
    }


}
