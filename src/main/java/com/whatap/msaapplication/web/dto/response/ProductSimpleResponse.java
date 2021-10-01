package com.whatap.msaapplication.web.dto.response;

import com.whatap.msaapplication.web.domain.product.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProductSimpleResponse {

    private String name;
    private int price;
    private int stockQuantity;


    @Builder
    public ProductSimpleResponse(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public static ProductSimpleResponse of (Product product) {
        return builder()
                .name(product.getName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .build();
    }


}
