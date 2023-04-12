package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;

public class CreamImpl extends ProductImpl implements Cream {
    private final ScentType scent;
    public CreamImpl(String name, String brand, double price, GenderType genderType, ScentType scentType) {
        super(name, brand, price, genderType);
        this.scent = scentType;
    }

    @Override
    public ScentType getScent() {
        return scent;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("#%s %s",this.getName(), this.getBrandName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" #Price: $%.2f",this.getPrice()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" #Gender: %s",this.getGenderType().name()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" #Scent: %s",this.getScent()));
        sb.append(System.lineSeparator());
        sb.append(" ===");
        return sb.toString();
    }
}
