package com.finance.productms.repository;


import com.finance.productms.domain.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductRepositoryExt extends ReactiveMongoRepository<Product, String > {
    Mono<Product> findByName(String name);
}
