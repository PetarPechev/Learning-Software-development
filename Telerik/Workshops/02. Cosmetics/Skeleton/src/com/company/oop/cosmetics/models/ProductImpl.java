package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public abstract class ProductImpl implements Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;


    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    protected ProductImpl (String name, String brand, double price, GenderType genderType){
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = genderType;
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");

        this.name = name;
    }

    private void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "Brand");

        this.brand = brand;
    }

    private void setPrice(double price) {
        ValidationHelpers.validatePrice(price);

        this.price = price;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrandName() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGenderType() {
        return gender;
    }


}
