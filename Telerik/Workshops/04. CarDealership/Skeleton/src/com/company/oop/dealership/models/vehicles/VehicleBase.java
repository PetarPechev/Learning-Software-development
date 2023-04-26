package com.company.oop.dealership.models.vehicles;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.vehicles.enums.VehicleType;
import com.company.oop.dealership.models.vehicles.contracts.Vehicle;
import com.company.oop.dealership.utils.FormattingHelpers;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class VehicleBase implements Vehicle {

    private static final int MAKE_NAME_LEN_MIN = 2;
    private static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    private static final int MODEL_NAME_LEN_MIN = 1;
    private static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    private static final double PRICE_VAL_MIN = 0;
    private static final double PRICE_VAL_MAX = 1000000;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);


    private String make;
    private String model;
    private double price;

    private final VehicleType vehicleType;
    private final int wheels;

    private final List<Comment> comments;


    protected VehicleBase(String make, String model, double price, VehicleType vehicleType) {
        setMake(make);
        setModel(model);
        setPrice(price);

        this.vehicleType = vehicleType;

        wheels = vehicleType.getWheelsCount();
        comments = new ArrayList<>();
    }


    private void setMake(String make) {
        validateMake(make);

        this.make = make;
    }

    private void validateMake(String make) {
        ValidationHelpers.validateIntRange(make.length(),
                MAKE_NAME_LEN_MIN,
                MAKE_NAME_LEN_MAX,
                MAKE_NAME_LEN_ERR);
    }

    @Override
    public String getMake() {
        return make;
    }

    private void setModel(String model) {
        validateModel(model);

        this.model = model;
    }

    private void validateModel(String model) {
        ValidationHelpers.validateIntRange(model.length(),
                MODEL_NAME_LEN_MIN,
                MODEL_NAME_LEN_MAX,
                MODEL_NAME_LEN_ERR);
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setPrice(double price) {
        validatePrice(price);

        this.price = price;
    }

    private void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(price,
                PRICE_VAL_MIN,
                PRICE_VAL_MAX,
                PRICE_VAL_ERR);
    }
    @Override
    public double getPrice() {
        return price;
    }


    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }


    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }


    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        String priceWithoutTrailingZeros = FormattingHelpers.removeTrailingZerosFromDouble(price);

        return "Make: " + make + System.lineSeparator() +
                "Model: " + model + System.lineSeparator() +
                "Wheels: " + wheels + System.lineSeparator() +
                "Price: $" + priceWithoutTrailingZeros;
    }

}
