package com.wipro.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.coupon.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {

    public Coupon findByCouponCode(String couponCode);
}