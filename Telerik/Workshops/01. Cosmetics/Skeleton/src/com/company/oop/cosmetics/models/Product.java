package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.Objects;

public class Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    public static final int BRAND_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);

        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public GenderType getGender() {
        return gender;
    }

    private void setName(String name) {
//        if (name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH) {
//            this.name = name;
//        } else {
//            throw new IllegalArgumentException();
//        }
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Invalid name length.");
        this.name = name;
    }

    private void setBrand(String brand) {
//        if (brand.length() >= BRAND_MIN_LENGTH && brand.length() <= BRAND_MAX_LENGTH) {
//            this.brand = brand;
//        } else {
//            throw new IllegalArgumentException();
//        }
        ValidationHelpers.validateStringLength(brand, BRAND_MIN_LENGTH, BRAND_MAX_LENGTH, "Invalid brand length.");
        this.brand = brand;
    }

    private void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String print() {
        return String.format(" #%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n" +
                " ===", name, brand, price, gender);
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }

}
