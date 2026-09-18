package com.wipro.coupon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coupon {

    @Id
    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "discount")
    private int discount;

    public Coupon() {
        super();
    }

    public Coupon(String couponCode, int discount) {
        super();
        this.couponCode = couponCode;
        this.discount = discount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}