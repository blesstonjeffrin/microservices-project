package com.wipro.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.coupon.client.ProductDto;
import com.wipro.coupon.entity.Coupon;
import com.wipro.coupon.service.CouponService;
import com.wipro.coupon.service.ProductIntegrationService;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponController {

    public CouponService couponService;
    public ProductIntegrationService productIntegrationService;

    public CouponController(
            @Autowired CouponService couponService,
            @Autowired ProductIntegrationService productIntegrationService) {
        super();
        this.couponService = couponService;
        this.productIntegrationService = productIntegrationService;
    }

    @PostMapping
    public Coupon addCoupon(@RequestBody Coupon coupon) {
        return couponService.addCoupon(coupon);
    }

    @GetMapping
    public List<Coupon> findAllCoupon() {
        return couponService.findAllCoupon();
    }

    @GetMapping("/{couponCode}")
    public ResponseEntity<Coupon> findCouponByCouponCode(
            @PathVariable String couponCode) {

        return new ResponseEntity<Coupon>(
                couponService.findCouponByCouponCode(couponCode),
                HttpStatus.OK);
    }

    @PutMapping("/{couponCode}/apply/{productId}")
    public ResponseEntity<ProductDto> applyCoupon(
            @PathVariable String couponCode,
            @PathVariable int productId) {

        Coupon coupon = couponService.findCouponByCouponCode(couponCode);

        ProductDto updatedProduct =
                productIntegrationService.applyDiscount(
                        productId,
                        coupon.getDiscount());

        return new ResponseEntity<ProductDto>(
                updatedProduct,
                HttpStatus.OK);
    }
}