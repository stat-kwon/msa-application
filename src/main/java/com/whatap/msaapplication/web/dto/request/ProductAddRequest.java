package com.whatap.msaapplication.web.dto.request;

import com.whatap.msaapplication.web.domain.product.Product;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProductAddRequest {
    private String name;
    private int price;
    private int stockQuantity;

    public Product addNewProduct(String name, int price, int stockQuantity) {
        return Product.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }

}
