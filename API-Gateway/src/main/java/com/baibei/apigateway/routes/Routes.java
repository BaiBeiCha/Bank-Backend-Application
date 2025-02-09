package com.baibei.apigateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@Configuration
public class Routes {

    @Value("${httpBase}")
    private String httpBase;

    @Bean
    public RouterFunction<ServerResponse> paymentServiceTestRoute() {
        String path = "/api/payment";
        return route("payment_service")
                .route(path(path), http(buildPath(8001, path)))
                .route(path(path + "/*"), http(buildPath(8001, path + "/*")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> transactionsServiceTestRoute() {
        String path = "/api/transactions";
        return route("transactions_service")
                .route(path(path), http(buildPath(8002, path)))
                .route(path(path + "/*"), http(buildPath(8002, path + "/*")))
                .build();
    }

    private String buildPath(int port, String path) {
        return httpBase + port + path;
    }
}
