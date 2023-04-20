package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;

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

    private void setDistance(int distance) {
        validateDistance(distance);

        this.distance = distance;
    }


    private void setDestination(String destination) {
        validateDestination(destination);

        this.destination = destination;
    }


    private void setStartLocation(String startLocation) {
        validateStartLocation(startLocation);

        this.startLocation = startLocation;
    }

    private void validateDestination(String destination) {
        ValidationHelper.validateStringLength(destination, DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH, "Destination's");
    }
    private void validateStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation, START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH, "StartingLocation's");
    }

    private void validateDistance(int distance) {
        ValidationHelper.validateDistance(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE);
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return "Journey ----" + System.lineSeparator() +
                "Start location: " + startLocation + System.lineSeparator() +
                "Destination: " + destination + System.lineSeparator() +
                "Distance: " + distance + System.lineSeparator() +
                "Vehicle type: " + vehicle + System.lineSeparator() +
                "Travel costs: " + calculateTravelCosts();
    }

}