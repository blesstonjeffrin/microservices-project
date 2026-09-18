package com.wipro.coupon.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-restapp")
public interface ProductClient {

    @PutMapping("/api/v1/products/{id}/discount")
    ProductDto applyDiscount(
            @PathVariable("id") int id,
            @RequestParam("discountPercent") int discountPercent);
}