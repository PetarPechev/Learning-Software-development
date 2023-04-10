package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {

        return new ArrayList<>(products);
    }

    /**
     * Adds a product to the list of products in this category.
     *
     * @param product the product to add to the list
     *
     * @author Petar Pechev
     */
    public void addProduct(Product product) {
        products.add(product);
    }


    /**
     * Removes the given product from the shopping cart. Throws an exception if the product is not in the shopping cart.
     *
     * @param product the product to remove
     *
     * @throws IllegalArgumentException if the product is not in the shopping cart
     *
     * @author Petar Pechev
     */
    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException("No product in shopping cart!");
        }

        products.remove(product);
    }


    /**
     * Checks if the shopping cart contains a specific product.
     *
     * @param product the product to be checked
     *
     * @return true if the product is contained in the shopping cart, false otherwise
     *
     * @author Petar Pechev
     */
    public boolean containsProduct(Product product) {
        return products.contains(product);
    }


    /**
     * Calculates the total price of all products in the shopping cart.
     *
     * @return the total price as a double.
     *
     * @author Petar Pechev
     */
    public double totalPrice() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    
}
