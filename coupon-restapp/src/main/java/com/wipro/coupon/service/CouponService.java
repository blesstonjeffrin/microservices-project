package com.wipro.coupon.service;

import java.util.List;

import com.wipro.coupon.entity.Coupon;

public interface CouponService {

    public Coupon addCoupon(Coupon coupon);

    public List<Coupon> findAllCoupon();

    public Coupon findCouponByCouponCode(String couponCode);
}