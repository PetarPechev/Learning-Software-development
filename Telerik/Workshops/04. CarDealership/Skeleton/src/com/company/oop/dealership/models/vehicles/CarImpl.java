package com.company.oop.dealership.models.vehicles;

import com.company.oop.dealership.models.vehicles.enums.VehicleType;
import com.company.oop.dealership.models.vehicles.contracts.Car;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CarImpl extends VehicleImpl implements Car {

    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);


    private int seats;


    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price, VehicleType.CAR);

        setSeats(seats);
    }


    private void setSeats(int seats) {
        validateSeats(seats);

        this.seats = seats;
    }

    private void validateSeats(int seats) {
        ValidationHelpers.validateIntRange(seats,
                CAR_SEATS_MIN,
                CAR_SEATS_MAX,
                CAR_SEATS_ERR);
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Car:" + System.lineSeparator() +
                super.toString() + System.lineSeparator() +
                "Seats: " + seats + System.lineSeparator();
    }
}
