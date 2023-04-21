package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleImpl implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;


    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, VehicleType.LAND, pricePerKilometer);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validatePassengerCapacity(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "bus");
    }


    @Override
    public String getAsString() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Bus ----" + System.lineSeparator() +
                super.toString();
    }

}