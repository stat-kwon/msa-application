package com.whatap.msaapplication.web.domain.product;

import com.whatap.msaapplication.web.domain.BaseTimeEntity;
import com.whatap.msaapplication.web.dto.request.ProductUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockQuantity;

    @Builder
    public Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Product updateProduct(ProductUpdateRequest updateRequest) {
        this.name = updateRequest.getName();
        this.price = updateRequest.getPrice();
        this.stockQuantity = updateRequest.getStockQuantity();
        return this;
    }
}
