package com.company;

public class CatalogLine {
    private Product productType;
    private int productNum;
    private double productPrice;

    CatalogLine(Product productType, int productNum, double productPrice) {
        this.productType = productType;
        this.productNum = productNum;
        this.productPrice = productPrice;
    }

    public Product getProductType() {
        return productType;
    }

    public int getProductNum() {
        return productNum;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void addProductNum(int dopNum) {
        productNum += dopNum;
    }

    public void deleteProductNum(int deleteNum) {
        productNum -= deleteNum;
    }
}
