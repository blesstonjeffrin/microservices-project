package com.wipro.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CouponRestappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponRestappApplication.class, args);
    }

}