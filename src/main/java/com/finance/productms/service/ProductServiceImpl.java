package com.finance.productms.service;

import com.finance.productms.document.Product;
import com.finance.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> findAll(){
        return productRepository.findAll();
    }

    public Mono<Product> findById(String id){
        return productRepository.findById(id);
    }

    public Mono<Product> save(Product product){
        return productRepository.save(product);
    }

    public Mono<Void> deleteById(String id){
        return  productRepository.deleteById(id);
    }

}
