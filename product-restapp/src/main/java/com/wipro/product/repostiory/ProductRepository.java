package com.wipro.product.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findByproductName(String productName);

}