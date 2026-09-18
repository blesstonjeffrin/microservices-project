package com.wipro.coupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.coupon.entity.Coupon;
import com.wipro.coupon.exception.CouponCodeNotFoundException;
import com.wipro.coupon.repository.CouponRepository;

import jakarta.transaction.Transactional;

@Service
public class CouponServiceImpl implements CouponService {

    private CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        super();
        this.couponRepository = couponRepository;
    }

    @Transactional
    @Override
    public Coupon addCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> findAllCoupon() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon findCouponByCouponCode(String couponCode) {

        Optional<Coupon> optionalContainer =
                couponRepository.findById(couponCode);

        if (optionalContainer.isPresent()) {
            return optionalContainer.get();
        } else {
            throw new CouponCodeNotFoundException(couponCode);
        }
    }
}