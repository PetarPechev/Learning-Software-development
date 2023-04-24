package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public abstract class VehicleImpl implements Vehicle {

    public static final int MAKE_NAME_LEN_MIN = 2;
    public static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    public static final int MODEL_NAME_LEN_MIN = 1;
    public static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    public static final double PRICE_VAL_MIN = 0;
    public static final double PRICE_VAL_MAX = 1000000;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);



    private String make;
    private String model;
    private int wheels;
    private double price;


    public VehicleImpl(String make, String model, int wheels, double price) {
        validateMake(make);
        validateModel(model);
        this.wheels = wheels;
        validatePrice(price);
    }

    private void validateMake(String make) {
        ValidationHelpers.validateIntRange(make.length(),
                MAKE_NAME_LEN_MIN,
                MAKE_NAME_LEN_MAX,
                MAKE_NAME_LEN_ERR);
    }

    private void validateModel(String model) {
        ValidationHelpers.validateIntRange(model.length(),
                MODEL_NAME_LEN_MIN,
                MODEL_NAME_LEN_MAX,
                MODEL_NAME_LEN_ERR);
    }

    private void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(price,
                PRICE_VAL_MIN,
                PRICE_VAL_MAX,
                PRICE_VAL_ERR);
    }






}
