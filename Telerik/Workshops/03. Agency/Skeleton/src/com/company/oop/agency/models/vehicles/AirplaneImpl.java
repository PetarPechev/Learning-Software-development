package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ParsingHelpers;

public class AirplaneImpl extends VehicleImpl implements Airplane {

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
    public String getAsString() {
        return this.toString();
    }


    public String toString() {
        return "Airplane ----" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                String.format("Has free food: %s", hasFreeFood);
    }
}