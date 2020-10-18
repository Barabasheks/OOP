package com.company;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Shop {
    private int shopId;
    private static int currentShopId = 0;
    private String shopName;
    private String address;
    private ArrayList<CatalogLine> catalog;
    private static ArrayList<Shop> allShops = new ArrayList<>();

    public Shop(String shopName, String address) {
        this.shopId = currentShopId;
        currentShopId++;
        this.shopName = shopName;
        this.address = address;
        this.catalog = new ArrayList<>();
        allShops.add(this);
    }

    @Nullable
    private CatalogLine getCatalogLine(Product product){
        for (var catalogLine: catalog){
            if (catalogLine.getProductType() == product)
                return catalogLine;
        }
        return null;
    }

    public void addProducts(@NotNull CatalogLine... newCatalogLines) {
        for (var newCatalogLine : newCatalogLines) {
            boolean findCatalogLine = false;
            for (var catalogLine: catalog){
                if (catalogLine.getProductType() == newCatalogLine.getProductType()){
                    findCatalogLine = true;
                    catalogLine.addProductNum(newCatalogLine.getProductNum());
                    catalogLine.setProductPrice(newCatalogLine.getProductPrice());
                    break;
                }
            }
            if (!findCatalogLine){
                catalog.add(newCatalogLine);
            }
        }
    }

    public void addProductsWithoutPrice(@NotNull Pair... pairs){
        for (var pair: pairs){
            for (var catalogLine: catalog){
                if (catalogLine.getProductType() == pair.getProductType()){
                    catalogLine.addProductNum(pair.getProductNum());
                    break;
                }
            }
        }
    }

    public ArrayList<Pair> canBuy(double money) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (var catalogLine: this.catalog){
            int productNum = (int)(money/catalogLine.getProductPrice());
            productNum = Math.min(productNum, catalogLine.getProductNum());
            pairs.add(new Pair(catalogLine.getProductType(), productNum));
        }
        return pairs;
    }

    public double buy(@NotNull Pair... pairs) throws RuntimeException{
        double sumPrice = 0;
        for (var pair: pairs){
            var catalogLine = this.getCatalogLine(pair.getProductType());
            if (catalogLine == null || catalogLine.getProductNum() < pair.getProductNum())
                throw new RuntimeException("Not enough products");
        }
        for (var pair: pairs){
            var catalogLine = this.getCatalogLine(pair.getProductType());
            catalogLine.deleteProductNum(pair.getProductNum());
            sumPrice += catalogLine.getProductPrice() * pair.getProductNum();
        }
        return sumPrice;
    }

    public int getShopId() {
        return shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<CatalogLine> getCatalog() {
        return catalog;
    }

    public static Shop findShopByOneProduct(@NotNull Product product) {
        double minPrice = 0;
        boolean minShopIsNull = true;
        Shop minShop = null;
        for (var shop: allShops){
            var catalogLine = shop.getCatalogLine(product);
            if (catalogLine == null) continue;
            if (catalogLine.getProductPrice() < minPrice || minShopIsNull){
                minPrice = catalogLine.getProductPrice();
                minShop = shop;
                minShopIsNull = false;
            }
        }
        return minShop;
    }

    public static Shop findShopByProducts(@NotNull Pair... pairs) {
        double minSum = 0;
        boolean minShopIsNull = true;
        Shop minShop = null;
        for (var shop: allShops){
            double currentSum = 0;
            boolean allProductsHave = true;
            for (var pair: pairs) {
                var catalogLine = shop.getCatalogLine(pair.getProductType());
                if (catalogLine == null || catalogLine.getProductNum() < pair.getProductNum()){
                    allProductsHave = false;
                    break;
                }
                currentSum += catalogLine.getProductPrice() * pair.getProductNum();
            }
            if (allProductsHave && (currentSum < minSum || minShopIsNull)) {
                minShop = shop;
                minShopIsNull = false;
                minSum = currentSum;
            }
        }
        return minShop;
    }
}
