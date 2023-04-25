package com.company.oop.dealership.models.vehicles.enums;

public enum VehicleType {
    MOTORCYCLE(2),
    CAR(4),
    TRUCK(8);


    private final int wheelsCount;

    VehicleType(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    @Override
    public String toString() {
        switch (this) {
            case CAR:
                return "Car";
            case MOTORCYCLE:
                return "Motorcycle";
            case TRUCK:
                return "Truck";
            default:
                throw new UnsupportedOperationException("Can't convert vehicle type.");
        }
    }
}


