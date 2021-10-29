package com.finance.productService.service;

import com.finance.productService.document.Product;
import com.finance.productService.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public Flux<Product> findAll(){
        return productRepository.findAll();
    }

    public Mono<Product> findById(String id){
        return productRepository.findById(id);
    }

    public Mono<Product> save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(String id){
        productRepository.deleteById(id);
    }

}
