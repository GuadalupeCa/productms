package com.finance.productService.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String productType;

    public Product(String name, String productType) {
        this.name = name;
        this.productType = productType;
    }
}
