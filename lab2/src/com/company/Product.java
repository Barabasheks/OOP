package com.company;

public class Product {
    private int productId;
    private static int currentProductId = 0;
    private String productName;

    public Product(String productName) {
        this.productId = currentProductId;
        currentProductId++;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
