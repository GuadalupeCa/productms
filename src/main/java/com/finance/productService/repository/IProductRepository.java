package com.finance.productService.repository;

import com.finance.productService.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductRepository {
    Flux<Product> findAll();
    Mono<Product> findById(String id);
    Mono<Product> save(Product product);
    void deleteById(String id);

}
