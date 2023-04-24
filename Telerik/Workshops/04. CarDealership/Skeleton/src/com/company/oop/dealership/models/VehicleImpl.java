package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.FormattingHelpers;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

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
    private double price;

    private final VehicleType type;
    private final int wheels;

    private final List<Comment> comments;



    public VehicleImpl(String make, String model, double price, VehicleType type) {
        setMake(make);
        setModel(model);
        setPrice(price);

        this.type = type;
        this.wheels = type.getWheelsCount();

        comments = new ArrayList<>();
    }



    private void setMake(String make) {
        validateMake(make);

        this.make = make;
    }

    private void setModel(String model) {
        validateModel(model);

        this.model = model;
    }
    private void setPrice(double price) {
        validatePrice(price);

        this.price = price;
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


    @Override
    public String toString() {
        String priceWithoutTrailingZeros = FormattingHelpers.removeTrailingZerosFromDouble(price);

        return "Make: " + make + System.lineSeparator() +
                "Model: " + model + System.lineSeparator() +
                "Wheels: " + wheels + System.lineSeparator() +
                "Price: $" + priceWithoutTrailingZeros;
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void addComment(Comment comment) {

        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public String printComments(List<Comment> comments) {
        if (comments.isEmpty()) {
            return "--NO COMMENTS--";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("--COMMENTS--").append(System.lineSeparator());

        for (int index = 0; index < comments.size(); index++) {
           sb.append(getCommentInfoAsStringWithSeparator(index, comments));
        }

        sb.append("--COMMENTS--");

        return sb.toString();
    }

    private String getCommentInfoAsStringWithSeparator(int index, List<Comment> comments) {
        String separator = "----------";

        return  separator + System.lineSeparator() +
                comments.get(index).getContent() + System.lineSeparator() +
                "User: " + comments.get(index).getAuthor() + System.lineSeparator() +
                separator + System.lineSeparator();
    }
}
