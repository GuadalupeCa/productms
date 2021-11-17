package com.finance.productms.service;

import com.finance.productms.domain.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    public Flux<Product> findAll();

    public Mono<Product> findById(String id);

    public Mono<Product> save(Product product);

    public Mono<Void> deleteById(String id);
    public Mono<Product> findByName(String name);
}
