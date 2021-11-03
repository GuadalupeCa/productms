package com.finance.productms.repository;


import com.finance.productms.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepositoryExt extends ReactiveMongoRepository<Product, String > {
}
