package com.wipro.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.product.entity.Product;
import com.wipro.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public ProductService productService;

    // LoadBalancer code
    @Value("${server.port}")
    private String port;

    public ProductController(@Autowired ProductService productService) {
        super();
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> listOfProduct() {
        return productService.listOfProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findByProductId(@PathVariable int id) {

        // LoadBalancer Check status
        System.out.println(
            ">>> [findByProductId] Handled by product-restapp instance on port: "
            + port
        );

        return new ResponseEntity<Product>(
            productService.findByProductId(id),
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}/discount")
    public ResponseEntity<Product> applyDiscount(
            @PathVariable int id,
            @RequestParam int discountPercent) {

        // LoadBalancer Check status
        System.out.println(
            ">>> [applyDiscount] Handled by product-restapp instance on port: "
            + port
        );

        return new ResponseEntity<Product>(
            productService.applyDiscount(id, discountPercent),
            HttpStatus.OK
        );
    }
}