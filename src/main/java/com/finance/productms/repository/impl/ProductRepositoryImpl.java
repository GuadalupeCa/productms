package com.finance.productms.repository.impl;

import com.finance.productms.domain.document.Product;
import com.finance.productms.repository.ProductRepository;
import com.finance.productms.repository.ProductRepositoryExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductRepositoryExt productRepository;

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    public Mono<Void> deleteById(String id) {
        return productRepository.deleteById(id);
    }

    @Override
    public Mono<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
