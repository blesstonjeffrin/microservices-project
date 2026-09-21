package com.wipro.coupon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wipro.coupon.entity.Coupon;
import com.wipro.coupon.repository.CouponRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(CouponRepository couponRepository) {
        return args -> {

            Coupon coupon = new Coupon("SAVE10", 10);

            couponRepository.save(coupon);

        };
    }
}