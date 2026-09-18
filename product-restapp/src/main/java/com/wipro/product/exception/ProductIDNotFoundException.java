package com.wipro.product.exception;

public class ProductIDNotFoundException extends RuntimeException {

    private int pid;

    public ProductIDNotFoundException(int pid) {
        super();
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "ProductIDNotFoundException [pid=" + pid + "]";
    }
}