package com.lab604.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                // Movie info Service
                .route(p -> p.path("/api/students/**")
                        .uri("lb://STUDENT-INFO-SERVICE"))

                // Rating data Service
                .route(p -> p.path("/api/courses/**")
                        .uri("lb://GRADES-DATA-SERVICE"))
                .route(p -> p.path("/api/grades**")
                        .uri("lb://GRADES-DATA-SERVICE"))

                // Movie catalog Service
                .route(p -> p.path("/api/catalogs/**")
                        .uri("lb://STUDENT-CATALOG-SERVICE"))

                .build();
    }
}
