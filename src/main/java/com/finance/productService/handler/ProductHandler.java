package com.finance.productService.handler;

import com.finance.productService.document.Product;
import com.finance.productService.service.ProductService;
import com.mongodb.internal.connection.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductHandler {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Mono<ServerResponse> findAll() {
        log.info("Find all clients");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.findAll(), Product.class);
    }

    @GetMapping("/{id}")
    public Mono<ServerResponse> findById(@PathVariable("id") String id) {
        log.info("Find by Id: {}", id);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body( productService.findById(id).subscribe(), Product.class);
    }

    @PostMapping("/save")
    public void save(@RequestBody Product product) {
        productService.save(product).subscribe();
    }

    @PutMapping("/update")
    public Mono<ServerResponse> update(@RequestBody Product product){
        log.info("update product {}", product);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.save(product), Product.class);
    }

    @DeleteMapping("/delete/{}")
    public void delete(String id){
        log.info("delete product");
    }

}
