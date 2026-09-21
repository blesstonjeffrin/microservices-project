package com.wipro.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wipro.product.entity.Product;
import com.wipro.product.repostiory.ProductRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(ProductRepository productRepository) {
        return args -> {

            Product product = new Product();

            product.setProductName("Laptop");
            product.setQuantity(10);
            product.setPrice(55000.0);
            product.setDescription("Gaming Laptop");

            productRepository.save(product);

        };
    }
}