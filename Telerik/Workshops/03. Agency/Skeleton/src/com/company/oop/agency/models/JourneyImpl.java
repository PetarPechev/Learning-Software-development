package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    private static final int START_LOCATION_MIN_LENGTH = 5;
    private static final int START_LOCATION_MAX_LENGTH = 25;
    private static final int DESTINATION_MIN_LENGTH = 5;
    private static final int DESTINATION_MAX_LENGTH = 25;
    private static final int DISTANCE_MIN_VALUE = 5;
    private static final int DISTANCE_MAX_VALUE = 5000;


    private final int id;
    private String startLocation;
    private String destination;
    private int distance;
    private final Vehicle vehicle;


    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        this.id = id;
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.vehicle = vehicle;
    }


    private void setStartLocation(String startLocation) {
        validateStartLocation(startLocation);

        this.startLocation = startLocation;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    private void setDestination(String destination) {
        validateDestination(destination);

        this.destination = destination;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    private void setDistance(int distance) {
        validateDistance(distance);

        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void validateStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation, START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH, "StartingLocation's");
    }

    private void validateDestination(String destination) {
        ValidationHelper.validateStringLength(destination, DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH, "Destination's");
    }

    private void validateDistance(int distance) {
        ValidationHelper.validateDistance(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE);
    }


    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }


    @Override
    public String getAsString() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Journey ----" + System.lineSeparator() +
                "Start location: " + startLocation + System.lineSeparator() +
                "Destination: " + destination + System.lineSeparator() +
                "Distance: " + distance + System.lineSeparator() +
                "Vehicle type: " + getVehicle().getType() + System.lineSeparator() +
                String.format("Travel costs: %.2f", calculateTravelCosts());
    }

}