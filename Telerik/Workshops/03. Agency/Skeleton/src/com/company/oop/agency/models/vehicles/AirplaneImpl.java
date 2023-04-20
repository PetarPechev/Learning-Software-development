package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.utils.ParsingHelpers;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, VehicleType.AIR, pricePerKilometer);
        setHasFreeFood(hasFreeFood);
    }

    private void setHasFreeFood(boolean hasFreeFood) {
        validateFreeFoodInput(hasFreeFood);

        this.hasFreeFood = hasFreeFood;
    }

    private void validateFreeFoodInput(boolean hasFreeFood) {
        ParsingHelpers.tryParseBoolean(String.valueOf(hasFreeFood), String.valueOf(hasFreeFood));
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public String toString() {

        return "Airplane ----" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                "Has free food: " + hasFreeFood;
    }
}