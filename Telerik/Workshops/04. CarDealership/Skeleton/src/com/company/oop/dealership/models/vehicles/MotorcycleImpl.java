package com.company.oop.dealership.models.vehicles;

import com.company.oop.dealership.models.vehicles.enums.VehicleType;
import com.company.oop.dealership.models.vehicles.contracts.Motorcycle;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleImpl implements Motorcycle {

    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);


    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price, VehicleType.MOTORCYCLE);

        setCategory(category);
    }

    private void setCategory(String category) {
        validateCategory(category);

        this.category = category;
    }

    private void validateCategory(String category) {
        ValidationHelpers.validateIntRange(category.length(),
                CATEGORY_LEN_MIN,
                CATEGORY_LEN_MAX,
                CATEGORY_LEN_ERR);
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Motorcycle:" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                "Category: " + category + System.lineSeparator();
    }
}
