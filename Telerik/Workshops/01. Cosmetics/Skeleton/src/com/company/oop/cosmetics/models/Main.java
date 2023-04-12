package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("product1", "brand1", 10, GenderType.UNISEX));
        shoppingCart.addProduct(new Product("product2", "brand2", 20, GenderType.UNISEX));

        List<Product> products = shoppingCart.getProducts();
        products.clear();

        for (Product product : shoppingCart.getProducts()) {
            System.out.println(product.getName());
        }
    }
}
