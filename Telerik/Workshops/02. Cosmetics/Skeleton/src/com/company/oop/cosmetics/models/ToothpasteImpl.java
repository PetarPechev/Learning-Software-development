package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductImpl implements Toothpaste {

    private final List<String> ingredients;

    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name, brandName, price, genderType);
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
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
        sb.append(" #Ingredients: ").append(ingredients.toString());
        sb.append(System.lineSeparator());
        sb.append(" ===");
        return sb.toString();
    }




     //This method should be uncommented when you are done with the class.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}
