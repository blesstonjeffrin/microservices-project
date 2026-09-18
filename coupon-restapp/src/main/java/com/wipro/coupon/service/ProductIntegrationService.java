package com.wipro.coupon.service;

import org.springframework.stereotype.Service;

import com.wipro.coupon.client.ProductClient;
import com.wipro.coupon.client.ProductDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductIntegrationService {

    private final ProductClient productClient;

    public ProductIntegrationService(ProductClient productClient) {
        this.productClient = productClient;
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "applyDiscountFallback")
    public ProductDto applyDiscount(int productId, int discountPercent) {
        return productClient.applyDiscount(productId, discountPercent);
    }

    public ProductDto applyDiscountFallback(
            int productId,
            int discountPercent,
            Throwable t) {

        System.out.println(
                ">>> Fallback triggered for product "
                + productId
                + " — reason: "
                + t.getMessage());

        ProductDto fallbackDto = new ProductDto();
        fallbackDto.setPid(productId);

        return fallbackDto;
    }
}