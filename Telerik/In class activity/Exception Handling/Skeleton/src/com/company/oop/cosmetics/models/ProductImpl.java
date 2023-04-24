package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ProductImpl implements Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        //TODO Validate name

        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        ValidationHelpers.validateStringLength(name,
                NAME_MIN_LENGTH,
                NAME_MAX_LENGTH,
                "Product name");
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        //TODO Validate brand
        validateBrand(brand);

        this.brand = brand;
    }

    private void validateBrand(String brand) {
        ValidationHelpers.validateStringLength(brand,
                BRAND_NAME_MIN_LENGTH,
                BRAND_NAME_MAX_LENGTH,
                "Product brand");
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        //TODO Validate price
        validatePrice(price);

        this.price = price;
    }

    private void validatePrice(double price) {
        ValidationHelpers.validatePrice(price);
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }

}
