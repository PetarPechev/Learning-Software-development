package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ShampooImpl extends ProductImpl implements Shampoo {
    private int millilitres;
    private final UsageType usageType;


    public ShampooImpl(String name, String brand, double price, GenderType genderType, int millilitres, UsageType usageType) {
        super(name, brand, price, genderType);

        setMillilitres(millilitres);
        this.usageType = usageType;
    }

    private void setMillilitres(int millilitres) {
        ValidationHelpers.validateMillilitres(millilitres);

        this.millilitres = millilitres;
    }

    @Override
    public int getMillilitres() {
        return millilitres;
    }

    @Override
    public UsageType getUsageType() {
        return usageType;
    }

    @Override
    public String print() {
        return String.format("%s%n" +
                " #Milliliters: %d%n" +
                " #Usage: %s%n", super.print(), millilitres, usageType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShampooImpl shampoo = (ShampooImpl) o;

        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
}
