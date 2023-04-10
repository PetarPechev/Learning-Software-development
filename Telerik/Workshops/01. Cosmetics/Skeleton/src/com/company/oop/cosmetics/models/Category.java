package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 15;

    private String name;
    private final List<Product> products;

    public Category(String name) {
        setName(name);
        products = new ArrayList<>();
    }


    /**
     * Sets the name of the user.
     * The name should be between {@value #NAME_MIN_LENGTH} and {@value #NAME_MAX_LENGTH} characters long.
     *
     * @param name the name to be set
     *
     * @throws IllegalArgumentException if the name length is invalid
     *
     * @author Petar Pechev
     */
    private void setName(String name) {
        String errorMessage = String.format("Invalid name length! Name should be between %d and %d characters long.",
                NAME_MIN_LENGTH, NAME_MAX_LENGTH);

        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, errorMessage);

        this.name = name;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     *
     * @author Petar Pechev
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the list of products associated with this order.
     *
     * @return the list of products
     *
     * @author Petar Pechev
     */
    public List<Product> getProducts() {
        return products;
    }


    /**
     * Adds the specified product to the list of products associated with this order.
     *
     * @param product the product to add
     *
     * @author Petar Pechev
     */
    public void addProduct(Product product) {
        products.add(product);
    }


    /**
     * Removes the specified product from the list of products associated with this order.
     * Throws an IllegalArgumentException if the product is not found in the list.
     *
     * @param product the product to remove
     *
     * @throws IllegalArgumentException if the product is not found in the list
     *
     * @author Petar Pechev
     */
    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException("No product in this category!");
        }

        products.remove(product);
    }


    /**
     * Returns a string representation of the category and its products.
     *  * The string starts with the category name, followed by a list of
     *  * the products in the category. If the category has no products, a
     *  * special message is included instead of the product list.
     *
     * @return A String with the Category's name and all its products
     *
     * @author Petar Pechev
     */
    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("#Category: %s",name)).append(System.lineSeparator());

        if (products.size()==0){
            builder.append(" #No product in this category");
            return builder.toString();
        }
        for (Product product : products) {
            builder.append(product.print());
        }

        return builder.toString();
    }
    
}
