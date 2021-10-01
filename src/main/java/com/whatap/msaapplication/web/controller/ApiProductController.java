package com.whatap.msaapplication.web.controller;

import com.whatap.msaapplication.service.ApiProductService;
import com.whatap.msaapplication.web.dto.request.ProductAddRequest;
import com.whatap.msaapplication.web.dto.request.ProductUpdateRequest;
import com.whatap.msaapplication.web.dto.response.ProductSimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RequestMapping("/api/products")
@RequiredArgsConstructor
@RestController
public class ApiProductController {

    private final ApiProductService apiProductService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductSimpleResponse> getProduct(@PathVariable Long productId) {
        log.info("Product Id: {} ", productId);
        return ResponseEntity.ok().body(apiProductService.findById(productId));
    }

    @GetMapping("")
    public ResponseEntity<List<ProductSimpleResponse>> getProductsByPagination(Pageable pageable) {
        return ResponseEntity.ok().body(apiProductService.getProductsByPagination(pageable));
    }

    @PostMapping("")
    public ResponseEntity<Void> addProduct(@RequestBody ProductAddRequest productAddRequest) {
        log.info("Product add Request >> {}", productAddRequest);
        apiProductService.addNewProduct(productAddRequest);
        return ResponseEntity.created(URI.create("/api/products")).build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId,
                                              @RequestBody ProductUpdateRequest productUpdateRequest) {
        log.info("Update Request Info {}", productUpdateRequest);
        apiProductService.updateProductInfo(productId, productUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        apiProductService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
