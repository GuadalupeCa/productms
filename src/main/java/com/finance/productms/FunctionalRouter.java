package com.finance.productms;

import com.finance.productms.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class FunctionalRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ProductHandler productHandler) {
        return RouterFunctions
                .route(GET("/product").and(accept(MediaType.APPLICATION_JSON)), productHandler::findAll)
                .andRoute(GET("/product/{id}").and(accept(MediaType.APPLICATION_JSON)), productHandler::findById)
                .andRoute(POST("/product/save").and(accept(MediaType.APPLICATION_JSON)), productHandler::save)
                .andRoute(PUT("/product/update").and(accept(MediaType.APPLICATION_JSON)), productHandler::update)
                .andRoute(DELETE("/product/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), productHandler::delete);
    }
}
