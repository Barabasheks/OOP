package com.company;

public class Pair {
    private Product productType;
    private int productNum;

    Pair(Product productType, int productNum) {
        this.productType = productType;
        this.productNum = productNum;
    }

    public Product getProductType() {
        return productType;
    }

    public int getProductNum() {
        return productNum;
    }
}
