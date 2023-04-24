package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ProductImpl implements Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private final GenderType genderType;

    public ProductImpl(String name, String brand, double price, GenderType genderType) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.genderType = genderType;
    }

    private void setName(String name) {
        validateName(name);

        this.name = name;
    }



    @Override
    public String getName() {
        return name;
    }

    private void setBrand(String brand) {
        validateBrand(brand);

        this.brand = brand;
    }

    @Override
    public String getBrandName() {
        return brand;
    }

    private void setPrice(double price) {
        validatePrice(price);

        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGenderType() {
        return genderType;
    }

    protected void validateName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "name");
    }

    protected void validateBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "brand");
    }

    protected void validatePrice(double price) {

        ValidationHelpers.validatePrice(price);
    }

    @Override
    public String print() {
        return String.format("#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s", name, brand, price, genderType);
    }
}
