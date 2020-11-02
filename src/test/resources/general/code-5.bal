import ballerina/config;
import ballerina/http;
import ballerina/log;
import ballerina/oauth2;
oauth2:OutboundOAuth2Provider oauth2Provider1 = new({
    tokenUrl: "<Token URL for the authorization endpoint>",
    clientId: "<Client ID for the client credentials grant authentication>",
    clientSecret:
        "<Client secret for the client credentials grant authentication>",
    clientConfig: {
        secureSocket: {
            trustStore: {
                path: config:getAsString("b7a.home") +
                    "/bre/security/ballerinaTruststore.p12",
                password: "ballerina"
            }
        }
    }
});
http:BearerAuthHandler oauth2Handler1 = new(oauth2Provider1);http:Client clientEP1 = new("<URL of the secured endpoint>", {
        auth: {
            authHandler: oauth2Handler1
        },
        secureSocket: {
            trustStore: {
                path: config:getAsString("b7a.home") +
                    "/bre/security/ballerinaTruststore.p12",
                password: "ballerina"
            }
        }
    });
oauth2:OutboundOAuth2Provider oauth2Provider2 = new({
    tokenUrl: "<Token URL for the authorization endpoint>",
    username: "<Username for password grant authentication>",
    password: "<Password for password grant authentication>",
    clientId: "<Client ID for password grant authentication>",
    clientSecret: "<Client secret for password grant authentication>",
    clientConfig: {
        secureSocket: {
            trustStore: {
                path: config:getAsString("b7a.home") +
                    "/bre/security/ballerinaTruststore.p12",
                password: "ballerina"
            }
        }
    },
    refreshConfig: {
        refreshUrl: "<Refresh token URL for the refresh token server>",
        clientConfig: {
            secureSocket: {
                trustStore: {
                    path: config:getAsString("b7a.home") +
                        "/bre/security/ballerinaTruststore.p12",
                    password: "ballerina"
                }
            }
        }
    }
});
http:BearerAuthHandler oauth2Handler2 = new(oauth2Provider2);http:Client clientEP2 = new("<URL of the secured endpoint>", {
        auth: {
            authHandler: oauth2Handler2
        },
        secureSocket: {
            trustStore: {
                path: config:getAsString("b7a.home") +
                    "/bre/security/ballerinaTruststore.p12",
                password: "ballerina"
            }
        }
    });
oauth2:OutboundOAuth2Provider oauth2Provider3 = new({
    accessToken: "<Access token for the authorization endpoint>",
    refreshConfig: {
        clientId: "<Client ID for the authorization endpoint authentication>",
        clientSecret:
            "<Client secret for the authorization endpoint authentication>",
        refreshToken: "<Refresh token for the refresh token server>",
        refreshUrl: "<Refresh token URL for the refresh token server>",
        clientConfig: {
            secureSocket: {
                trustStore: {
                    path: config:getAsString("b7a.home") +
                        "/bre/security/ballerinaTruststore.p12",
                    password: "ballerina"
                }
            }
        }
    }
});
http:BearerAuthHandler oauth2Handler3 = new(oauth2Provider3);http:Client clientEP3 = new("<URL of the secured endpoint>", {
        auth: {
            authHandler: oauth2Handler3
        },
        secureSocket: {
            trustStore: {
                path: config:getAsString("b7a.home") +
                    "/bre/security/ballerinaTruststore.p12",
                password: "ballerina"
            }
        }
    });public function main() {
    var response = clientEP1->get("/hello/sayHello");
    if (response is http:Response) {
        var result = response.getTextPayload();
        log:printInfo(
            (result is error) ? "Failed to retrieve payload." : result);
    } else {
        log:printError("Failed to call the endpoint.", <error>response);
    }    response = clientEP2->get("/hello/sayHello");
    if (response is http:Response) {
        var result = response.getTextPayload();
        log:printInfo(
            (result is error) ? "Failed to retrieve payload." : result);
    } else {
        log:printError("Failed to call the endpoint.", <error>response);
    }    response = clientEP3->get("/hello/sayHello");
    if (response is http:Response) {
        var result = response.getTextPayload();
        log:printInfo(
            (result is error) ? "Failed to retrieve payload." : result);
    } else {
        log:printError("Failed to call the endpoint.", <error>response);
    }
}
