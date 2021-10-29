package com.finance.productService.repository;


import com.finance.productService.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepositoryExt extends ReactiveMongoRepository<Product, String > {
}
