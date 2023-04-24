package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleImpl implements Truck {

    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);


    private int weightCapacity;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price, VehicleType.TRUCK);

        setWeightCapacity(weightCapacity);
    }

    private void setWeightCapacity(int weightCapacity) {
        validateWeightCapacity(weightCapacity);

        this.weightCapacity = weightCapacity;
    }

    private void validateWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity,
                WEIGHT_CAP_MIN,
                WEIGHT_CAP_MAX,
                WEIGHT_CAP_ERR);
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public String toString() {
        return "Car:" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                "Weight capacity: " + weightCapacity + "t" + System.lineSeparator() +
                super.printComments(getComments());
    }

    //TODO
}
