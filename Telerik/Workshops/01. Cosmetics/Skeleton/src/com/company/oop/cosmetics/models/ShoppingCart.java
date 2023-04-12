package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean containsProduct(Product product) {
        return products.contains(product);
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
