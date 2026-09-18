package com.wipro.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.product.entity.Product;
import com.wipro.product.exception.ProductIDNotFoundException;
import com.wipro.product.repostiory.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> listOfProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findByProductName(String productName) {
        return productRepository.findByproductName(productName);
    }

    @Override
    public Product findByProductId(int pid) {

        Optional<Product> optionalContainer = productRepository.findById(pid);

        if (optionalContainer.isPresent())
            return optionalContainer.get();
        else
            throw new ProductIDNotFoundException(pid);
    }

    @Override
    public Product applyDiscount(int pid, int discountPercent) {

        Product product = productRepository.findById(pid)
                .orElseThrow(() ->
                    new RuntimeException("Product not found with id: " + pid));

        double discountedPrice =
                product.getPrice() -
                (product.getPrice() * discountPercent / 100.0);

        product.setPrice(discountedPrice);

        return productRepository.save(product);
    }
}