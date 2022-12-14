package com.xtoan.apigateway;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/product/**")
                        .uri("lb://PRODUCT-SERVICE")
                        )
                .route(r -> r.path("/api/category/**")
                        .uri("lb://PRODUCT-SERVICE")
                )
                .route(r -> r.path("/api/user/**")
                        .uri("lb://USER-SERVICE")
                        )
                .build();
    }

}
