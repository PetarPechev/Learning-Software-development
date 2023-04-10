package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.Locale;
import java.util.Objects;

public class Product {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;

    // "Each product in the system has name, brand, price and gender."
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    /**
     * Sets the name of the user.
     * The name should be between {@value #NAME_MIN_LENGTH} and {@value #NAME_MAX_LENGTH} characters long.
     *
     * @param name the name of the category to set
     *
     * @throws IllegalArgumentException if the name is not between NAME_MIN_LENGTH and NAME_MAX_LENGTH characters long
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
     * Returns the name of this category.
     *
     * @return the name of this category
     *
     * @author Petar Pechev
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the brand of the product.
     *
     * @param brand the brand to set for the product
     * @throws IllegalArgumentException if the brand length is less than BRAND_MIN_LENGTH or greater than BRAND_MAX_LENGTH
     *
     * @author Petar Pechev
     */
    private void setBrand(String brand) {
        String errorMessage = String.format("Invalid brand length! Brand should be between %d and %d characters long.",
                BRAND_MIN_LENGTH, BRAND_MAX_LENGTH);

        ValidationHelpers.validateStringLength(brand, BRAND_MIN_LENGTH, BRAND_MAX_LENGTH, errorMessage);

        this.brand = brand;
    }


    /**
     * Returns the brand of the product.
     *
     * @return the brand of the product
     *
     * @author Petar Pechev
     */
    public String getBrand() {
        return brand;
    }


    /**
     * Sets the price of the product.
     *
     * @param price the price to set for the product
     *
     * @throws IllegalArgumentException if the price is negative
     *
     * @author Petar Pechev
     */
    private void setPrice(double price) {
        if (price < 0.00) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }

        this.price = price;
    }


    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     *
     * @author Petar Pechev
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets the gender of the person to the specified gender.
     *
     * @param gender the gender to set for the person
     *
     * @author Petar Pechev
     */
    public void setGender(GenderType gender) {
        this.gender = gender;
    }


    /**
     * Returns the gender of the person.
     *
     * @return the gender of the person
     *
     * @author Petar Pechev
     */
    public GenderType getGender() {
        return gender;
    }


    /**
     * Generates a formatted string representation of the Product object.
     *
     * The format is as follows:
     * "#[Name] [Brand]
     * #Price: [Price]
     * #Gender: [Gender]
     * ==="
     *
     * @return a string representation of the Product object
     *
     * @author Petar Pechev
     */
    public String print() {
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" #%s %s", getName(), getBrand())).append(System.lineSeparator());
        sb.append(String.format("#Price: $%.2f", getPrice())).append(System.lineSeparator());
        sb.append(String.format("#Gender: %s", getGender())).append(System.lineSeparator());
        sb.append("===");

        return sb.toString();
    }


    /**
     * Checks if this product is equal to another object.
     * Two products are considered equal if they have the same name, brand, price, and gender
     *
     * @param obj the object to compare this product to.
     * @return true if the products are equal, false otherwise.
     *
     * @author Petar Pechev
     */
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
