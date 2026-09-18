package com.wipro.coupon.exception;

public class CouponCodeNotFoundException extends RuntimeException {

    private String couponCode;

    public CouponCodeNotFoundException(String couponCode) {
        super();
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "CouponCodeNotFoundException [couponCode=" + couponCode + "]";
    }
}