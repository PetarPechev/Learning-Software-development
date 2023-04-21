package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;

    private int carts;


    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, VehicleType.LAND, pricePerKilometer);

        setCarts(carts);
    }

    private void setCarts(int carts) {
        validateCarts(carts);

        this.carts = carts;
    }

    private void validateCarts(int carts) {
        ValidationHelper.validateCartsNumber(carts, CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validatePassengerCapacity(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "train");
    }


    @Override
    public int getCarts() {
        return carts;
    }



    @Override
    public String getAsString() {
        return String.format("Train ----%n") +
                super.toString() + System.lineSeparator() +
                String.format("Carts amount: %d", carts);
    }

    @Override
    public String toString() {
        return String.format("Train ----%n") +
                super.toString() + System.lineSeparator() +
                String.format("Carts amount: %d", carts);
    }
}