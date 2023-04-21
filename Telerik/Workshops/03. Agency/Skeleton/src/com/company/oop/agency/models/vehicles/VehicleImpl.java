package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleImpl implements Vehicle {
    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;


    private final int id;
    private int passengerCapacity;
    private final VehicleType vehicleType;
    private double pricePerKilometer;


    protected VehicleImpl(int id, int passengerCapacity, VehicleType vehicleType, double pricePerKilometer) {
        this.id = id;
        this.vehicleType = vehicleType;

        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }


    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);

        this.pricePerKilometer = pricePerKilometer;
    }


    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }


    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);

        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }


    @Override
    public VehicleType getType() {
        return vehicleType;
    }


    @Override
    public int getId() {
        return id;
    }

    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validatePassengerCapacity(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "vehicle");
    }

    private void validatePricePerKilometer(double pricePerKilometer) {
        ValidationHelper.validatePricePerKilometer(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, "vehicle");
    }

    @Override
    public String getAsString() {
        return this.toString();
    }


    @Override
    public String toString() {
        return String.format("Passenger capacity: %d%n", passengerCapacity) +
                String.format("Price per kilometer: %.2f%n", pricePerKilometer) +
                String.format("Vehicle type: %s", vehicleType);
    }


}
