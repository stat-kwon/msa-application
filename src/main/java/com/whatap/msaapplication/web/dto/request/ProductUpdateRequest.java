package com.whatap.msaapplication.web.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProductUpdateRequest {

    private String name;
    private int price;
    private int stockQuantity;

    @Builder
    public ProductUpdateRequest(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
