package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl extends ProductImpl implements Cream {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 15;
    private static final int BRAND_NAME_MIN_LENGTH = 3;
    private static final int BRAND_NAME_MAX_LENGTH = 15;

    private final ScentType scentType;

    public CreamImpl(String name, String brand, double price, GenderType genderType, ScentType scentType) {
        super(name, brand, price, genderType);

        this.scentType = scentType;
    }

    @Override
    protected void validateName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "name");
    }

    @Override
    protected void validateBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "brand");
    }

    @Override
    public ScentType getScent() {
        return scentType;
    }


    @Override
    public String print() {
        return String.format("%s%n" +
                " #Scent: %s%n", super.print(), scentType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CreamImpl cream = (CreamImpl) o;

        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                getGenderType().equals(cream.getGenderType()) &&
                getScent() == cream.getScent();
    }
}
