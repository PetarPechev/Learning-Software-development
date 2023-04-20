package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

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
        return "Train ----" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                "Carts amount: " + carts;
    }
}