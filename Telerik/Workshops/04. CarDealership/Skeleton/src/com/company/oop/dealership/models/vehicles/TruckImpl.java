package com.company.oop.dealership.models.vehicles;

import com.company.oop.dealership.models.vehicles.enums.VehicleType;
import com.company.oop.dealership.models.vehicles.contracts.Truck;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleImpl implements Truck {

    private static final int WEIGHT_CAP_MIN = 1;
    private static final int WEIGHT_CAP_MAX = 100;
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

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    private void validateWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity,
                WEIGHT_CAP_MIN,
                WEIGHT_CAP_MAX,
                WEIGHT_CAP_ERR);
    }


    @Override
    public String toString() {
        return "Truck:" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                "Weight Capacity: " + weightCapacity + "t" + System.lineSeparator();
    }
}
