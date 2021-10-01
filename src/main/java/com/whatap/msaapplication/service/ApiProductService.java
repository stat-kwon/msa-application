package com.whatap.msaapplication.service;

import com.whatap.msaapplication.web.domain.product.Product;
import com.whatap.msaapplication.web.domain.product.ProductRepository;
import com.whatap.msaapplication.web.dto.request.ProductAddRequest;
import com.whatap.msaapplication.web.dto.request.ProductUpdateRequest;
import com.whatap.msaapplication.web.dto.response.ProductSimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ApiProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductSimpleResponse findById(Long productId) {
        Product product = findProductById(productId);
        return ProductSimpleResponse.of(product);
    }

    @Transactional(readOnly = true)
    public List<ProductSimpleResponse> getProductsByPagination(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent()
                .stream()
                .map(product -> ProductSimpleResponse.of(product))
                .collect(Collectors.toList());
    }

    public Product addNewProduct(ProductAddRequest request) {
        isDuplicatedProduct(request.getName());
        Product newProduct = request.addNewProduct(request.getName(), request.getPrice(), request.getStockQuantity());
        return productRepository.save(newProduct);
    }

    public Product updateProductInfo(Long productId, ProductUpdateRequest productUpdateRequest) {
        Product savedProduct = findProductById(productId);
        return savedProduct.updateProduct(productUpdateRequest);
    }

    public void deleteProduct(Long productId) {
        Product product = findProductById(productId);
        productRepository.deleteById(product.getId());
    }

    private void isDuplicatedProduct(String name) {
        if (productRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
