package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;

    private String name;
    private final ArrayList<Product> products;

    public Category(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Invaind name length.");
        this.name = name;
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

    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("#Category: %s%n", name));
        if (products.isEmpty()) {
            result.append(" #No product in this category");
            return result.toString();
        }

        for (Product product : products) {
            result.append(product.print());
        }
        return result.toString();
    }

}
