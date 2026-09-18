package com.wipro.product.service;

import java.util.List;

import com.wipro.product.entity.Product;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> listOfProduct();

    public Product findByProductName(String productName);

    public Product findByProductId(int pid);

    Product applyDiscount(int pid, int discountPercent);
}