package com.finance.productService.handler;

import com.finance.productService.document.Product;
import com.finance.productService.service.ProductService;
import com.finance.productService.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ProductHandler {

    @Autowired
    private ProductService productService;

    public Mono findAll(ServerRequest request) {
        log.info("Find all products");
        return ServerResponse.ok()
                .body(productService.findAll(), Product.class);
    }

    public Mono findById(ServerRequest request) {
        String id = request.pathVariable("id");
        log.info("Find client by id: {}", id);
        return ServerResponse.ok()
                .body(productService.findById(id), Product.class);
    }

    public Mono save(ServerRequest request) {
        Mono<Product> product = request.bodyToMono(Product.class);
        log.info("Save product");
        return product.flatMap(p -> ServerResponse
                .status(HttpStatus.CREATED)
                .body(productService.save(p), Product.class));
    }

    public Mono update(ServerRequest request){
        Mono<Product> product = request.bodyToMono(Product.class);
        log.info("update product {}", product);
        return product.flatMap(p -> ServerResponse
                .status(HttpStatus.CREATED)
                .body(productService.save(p), Product.class));
    }

    public Mono delete(ServerRequest request){
        String id = request.pathVariable("id");
        log.info("delete product");
        return productService.deleteById(id).then(ServerResponse.noContent().build());
    }

}
