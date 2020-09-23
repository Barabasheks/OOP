package com.company;

public class Main {

    public static void main(String[] args) {
        Shop shop1 = new Shop("Shop1", "Street1");
        Shop shop2 = new Shop("Shop2", "Street2");
        Shop shop3 = new Shop("Shop3", "Street3");
        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        Product product3 = new Product("Product3");
        Product product4 = new Product("Product4");
        Product product5 = new Product("Product5");
        Product product6 = new Product("Product6");
        Product product7 = new Product("Product7");
        Product product8 = new Product("Product8");
        Product product9 = new Product("Product9");
        Product product10 = new Product("Product10");

        shop1.addProducts(new CatalogLine(product2, 3, 20),
                new CatalogLine(product4, 40,40), new CatalogLine(product6, 60,60),
                new CatalogLine(product8, 80, 80), new CatalogLine(product10, 100, 100));
        shop2.addProducts(new CatalogLine(product1, 10, 10),
                new CatalogLine(product3, 30,30), new CatalogLine(product5, 50,50),
                new CatalogLine(product7, 70, 70), new CatalogLine(product9, 90, 90));
        shop3.addProducts(new CatalogLine(product2, 20, 30));
        shop3.addProducts(new CatalogLine(product1, 5, 5));
        shop3.addProducts(new CatalogLine(product3, 15, 10));
        shop3.addProducts(new CatalogLine(product3, 10, 30));
        shop3.addProductsWithoutPrice(new Pair(product3, 5), new Pair(product4, 10));

        var shopCheapProd = Shop.findShopByOneProduct(product2);
        System.out.println(shopCheapProd.getShopName() + '\n');

        var prodCanBuy = shop1.canBuy(90);
        for (var pair: prodCanBuy){
            System.out.println(pair.getProductType().getProductName() + " - " + pair.getProductNum());
        }
        System.out.println();

        System.out.println(shop1.buy(new Pair(product2, 3), new Pair(product4, 30)));
        for (var line: shop1.getCatalog()){
            System.out.println(line.getProductType().getProductName() + " - " + line.getProductNum());
        }
        System.out.println();

        var shopCheapProds = Shop.findShopByProducts(new Pair(product1, 5), new Pair(product3, 10));
        System.out.println(shopCheapProds.getShopName());
        shopCheapProds = Shop.findShopByProducts(new Pair(product1, 10), new Pair(product3, 10));
        System.out.println(shopCheapProds.getShopName());
    }
}
